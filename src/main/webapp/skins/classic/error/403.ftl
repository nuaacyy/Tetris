<#include "../macro-head.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="403 Forbidden! - ${symphonyLabel}">
        <meta name="robots" content="none" />
        </@head>
        <link rel="stylesheet" href="${staticServePath}/css/error.css?${staticResourceVersion}" />
    </head>
    <body class="error error-403">
        <#include "../header.ftl">
        <div class="main">
            <div class="wrapper">
                <div class="module">
                    <h2 class="sub-head">${reloginLabel}</h2>
                    <div class="need-login">
                        <button onclick="Util.goLogin()" class="red">${loginLabel}</button> &nbsp;
                        <button onclick="Util.goRegister()" class="green">${nowLabel}${registerLabel}</button>
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        ${indexIntroLabel} &nbsp; &nbsp;
                        <a href="https://github.com/b3log/symphony" target="_blank" class="tooltipped tooltipped-n" aria-label="${siteCodeLabel}">
                            <svg class="icon-github"><use xlink:href="#github"></use></svg></a> &nbsp;
                        <a href="http://weibo.com/u/2778228501" target="_blank" class="tooltipped tooltipped-n" aria-label="${followWeiboLabel}">
                            <svg class="icon-weibo"><use xlink:href="#weibo"></use></svg></a>   &nbsp;
                        <a target="_blank" class="tooltipped tooltipped-n" aria-label="${joinQQGroupLabel}"
                           href="http://shang.qq.com/wpa/qunwpa?idkey=981d9282616274abb1752336e21b8036828f715a1c4d0628adcf208f2fd54f3a">
                            <svg class="icon-qq"><use xlink:href="#qq"></use></svg></a>
                    </div>
                </div>
            </div>
        </div>
        <#include '../footer.ftl'/>
    </body>
</html>
