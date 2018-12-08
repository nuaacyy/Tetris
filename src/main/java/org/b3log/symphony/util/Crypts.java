/*
 * Symphony - A modern community (forum/SNS/blog) platform written in Java.
 * Copyright (C) 2012-2018,  b3log.org & hacpai.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.b3log.symphony.util;

import org.apache.commons.codec.binary.Hex;
import org.b3log.latke.logging.Level;
import org.b3log.latke.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Cryptology utilities.
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.0.0.2, Sep 17, 2016
 * @since 1.0.0
 */
public final class Crypts {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Crypts.class);
	/**
	 * 使用到的演算法
	 */
	public static final String ALGORITHM = "AES";
	/**
	 * 编码规则
	 */
	public static final String CHARSET = "UTF-8";

	/**
	 * Encrypts by AES.
	 *
	 * @param content the specified content to encrypt
	 * @param key     the specified key
	 * @return encrypted content
	 * @see #decryptByAES(java.lang.String, java.lang.String)
	 */
	public static String encryptByAES(final String content, final String key) {
		try {
			final KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
			final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			kgen.init(128, secureRandom);
			final SecretKey secretKey = kgen.generateKey();
			final byte[] enCodeFormat = secretKey.getEncoded();
			final SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, ALGORITHM);
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			final byte[] byteContent = content.getBytes(CHARSET);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			final byte[] result = cipher.doFinal(byteContent);

			return Hex.encodeHexString(result);
		} catch (final Exception e) {
			LOGGER.log(Level.WARN, "Encrypt failed", e);

			return null;
		}
	}

	/**
	 * Decrypts by AES. aes解密 aes 即advanced encryption standard 高级加密标准
	 * <p>
	 * 是美国联邦政府采用的一种区块加密标准。这个标准用来替代原先的DES。2006年，高级加密标准已然成为<b>对称密钥加密</b>中最流行的算法之一。
	 * </p>
	 * 
	 * @param content the specified content to decrypt
	 * @param key     the specified key
	 * @return original content
	 * @see #encryptByAES(java.lang.String, java.lang.String)
	 */
	public static String decryptByAES(final String content, final String key) {
		try {
			final byte[] data = Hex.decodeHex(content.toCharArray());
			// 实例化支持AES算法的密钥生成器（算法名称命名需按规定，否则抛出异常）
			final KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
			final SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			kgen.init(128, secureRandom);
			final SecretKey secretKey = kgen.generateKey();
			final byte[] enCodeFormat = secretKey.getEncoded();
			final SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, ALGORITHM);
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			final byte[] result = cipher.doFinal(data);

			return new String(result, CHARSET);
		} catch (final Exception e) {
			LOGGER.log(Level.WARN, "Decrypt failed");

			return null;
		}
	}

	private Crypts() {
	}
}
