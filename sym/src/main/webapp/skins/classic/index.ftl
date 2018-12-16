<#include "macro-head.ftl">
<#include "common/title-icon.ftl">
<!DOCTYPE html>
<html>
    <head>
        <@head title="${symphonyLabel}">
        <meta name="description" content="${symDescriptionLabel}"/>
        </@head>
        <link rel="stylesheet" href="${staticServePath}/css/index.css?${staticResourceVersion}" />
        <link rel="canonical" href="${servePath}">
    </head>
    <body class="index">
        ${HeaderBannerLabel}
        <#include "header.ftl">
        <div class="main">
            <div class="wrapper">
                <div class="index-main">
                    <div class="index-tabs fn-flex" id="articles">
                        <span class="current" data-index="0">
                            <svg><use xlink:href="#refresh"></use></svg> ${latestLabel}
                        </span>
                        <span class="tags" data-index="1">
                            <svg><use xlink:href="#tags"></use></svg>
                            ${followingTagsLabel}
                        </span>
                        <span class="users" data-index="2">
                            <svg><use xlink:href="#userrole"></use></svg>
                            ${followingUsersLabel}
                        </span>
                    </div>
                    <div class="index-tabs-panels list article-list">
                        <ul>
                            <#list recentArticles as article>
                                <#include "common/list-item.ftl">
                            </#list>
                            <#if recentArticles?size == 0>
                                ${systemEmptyLabel}<br>
                                ${systemEmptyTipLabel}<br> 
                                <img src="${staticServePath}/images/404/5.gif"/>          
                            </#if>
                            <li>
                                <a class="more" href="${servePath}/recent">${moreRecentArticleLabel}</a>
                            </li>
                        </ul>
                        <ul class="fn-none">
                            <#list followingTagArticles as article>
                                <#include "common/list-item.ftl">
                            </#list>
                            <#if isLoggedIn && followingTagArticles?size == 0>
                                <li class="ft-center">
                                    ${noFollowingTagLabel}<br>
                                    ${noFollowingTagTipLabel}<br> 
                                    <img src="${staticServePath}/images/404/6.gif"/>     
                                </li>  
                            </#if>
                            <#if !isLoggedIn>
                                <li class="ft-center">
                                    ${noLoginLabel}<br>
                                    ${noLoginTipLabel}<br> 
                                    <img src="${staticServePath}/images/404/6.gif"/>     
                                </li>  
                            </#if>
                            <li>
                                <a class="more" href="${servePath}/recent">${moreRecentArticleLabel}</a>
                            </li>
                        </ul>
                        <ul class="fn-none">
                            <#list followingUserArticles as article>
                                <#include "common/list-item.ftl">
                            </#list>
                            <#if isLoggedIn && followingUserArticles?size == 0>
                                <li class="ft-center">
                                    ${noFollowingUserLabel}<br>
                                    ${noFollowingUserTipLabel}<br> 
                                    <img src="${staticServePath}/images/404/2.gif"/>     
                                </li> 
                            </#if>
                            <#if !isLoggedIn>
                                <li class="ft-center">
                                    ${noLoginLabel}<br>
                                    ${noLoginTipLabel}<br> 
                                    <img src="${staticServePath}/images/404/2.gif"/>     
                                </li>   
                            </#if>
                            <li>
                                <a class="more" href="${servePath}/recent">${moreRecentArticleLabel}</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="index-side">
                    <div class="index-tabs fn-flex">
                        <span class="perfect">
                            <a href="${servePath}/perfect">
                                <svg><use xlink:href="#perfect"></use></svg>
                            ${perfectLabel}
                            </a>
                        </span>
                        <span class="check">
                            <#if isLoggedIn && !isDailyCheckin>
                            <a href="<#if useCaptchaCheckin>${servePath}/activity/checkin<#else>${servePath}/activity/daily-checkin</#if>">${dailyCheckinLabel}</a>
                            <#else>
                            <a href="${servePath}/activities">
                                ${activityLabel}
                            </a>
                            </#if>
                        </span>
                        <span class="post"><a href="${servePath}/pre-post">${postArticleLabel}</a></span>
                    </div>
                    <div class="perfect-panel list">
                        <ul>
                            <#list perfectArticles as article>
                            <li>
                                <a rel="nofollow" href="${servePath}/member/${article.articleAuthorName}">
                                    <span class="avatar-small tooltipped tooltipped-se" aria-label="${article.articleAuthorName}" style="background-image:url('${article.articleAuthorThumbnailURL48}')"></span>
                                </a>
                                <a rel="nofollow" class="fn-ellipsis ft-a-title" href="${servePath}${article.articlePermalink}">${article.articleTitleEmoj}</a>
                                <a class="fn-right count ft-gray ft-smaller" href="${servePath}${article.articlePermalink}"><#if article.articleViewCount < 1000>
                                    ${article.articleViewCount}<#else>${article.articleViewCntDisplayFormat}</#if></a>
                            </li>
                            </#list>
                            <#if perfectArticles?size == 0>
                                <li>${chickenEggLabel}</li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="index__bottom">
                <div class="wrapper">
                    <div class="fn-flex-1">
                        <div class="metro-line fn-flex">
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag0.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag0.tagIconPath}" alt="${tag0.tagTitle}">
                                    <b>${tag0.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag1.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag1.tagIconPath}" alt="${tag1.tagTitle}">
                                    <b>${tag1.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag2.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag2.tagIconPath}" alt="${tag2.tagTitle}">
                                    <b>${tag2.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag3.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag3.tagIconPath}" alt="${tag3.tagTitle}">
                                    <b>${tag3.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag4.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag4.tagIconPath}" alt="${tag4.tagTitle}">
                                    <b>${tag4.tagTitle}</b>
                                </a>
                            </div>
                        </div>
                        <div class="metro-line fn-flex">
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag5.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag5.tagIconPath}" alt="${tag5.tagTitle}">
                                    <b>${tag5.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag6.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag6.tagIconPath}" alt="${tag6.tagTitle}">
                                    <b>${tag6.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag7.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag7.tagIconPath}" alt="${tag7.tagTitle}">
                                    <b>${tag7.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag8.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag8.tagIconPath}" alt="${tag8.tagTitle}">
                                    <b>${tag8.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag9.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag9.tagIconPath}" alt="${tag9.tagTitle}">
                                    <b>${tag9.tagTitle}</b>
                                </a>
                            </div>
                        </div>
                        <div class="metro-line fn-flex">
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag10.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag10.tagIconPath}" alt="${tag10.tagTitle}">
                                    <b>${tag10.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag11.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag11.tagIconPath}" alt="${tag11.tagTitle}">
                                    <b>${tag11.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                                <a class="preview" href="${servePath}/tag/${tag12.tagURI}">
                                    <img src="${staticServePath}/images/tags/${tag12.tagIconPath}" alt="${tag12.tagTitle}">
                                    <b>${tag12.tagTitle}</b>
                                </a>
                            </div>
                            <div class="metro-item">
                            <#if ADLabel != '' >
                                <a class="preview" href="https://hacpai.com/article/1460083956075">
                                    <img src="${staticServePath}/emoji/graphics/heart.png" alt="${sponsorLabel}">
                                    <b>${adDeliveryLabel}</b>
                                </a>
                            <#else>
                                <a class="preview" href="https://hacpai.com/man">
                                    <img src="${staticServePath}/images/tags/shell.png" alt="${sponsorLabel}">
                                    <b>Hacker's Manual</b>
                                </a>
                            </#if>
                            </div>
                            <div class="metro-item">
                            <#if ADLabel != '' >
                                <div class="ad">
                                ${ADLabel}
                                </div>
                            <#else>
                                <a class="preview" href="https://hacpai.com/article/1460083956075">
                                    <img src="${staticServePath}/emoji/graphics/heart.png" alt="${sponsorLabel}">
                                    <b>${adDeliveryLabel}</b>
                                </a>
                            </#if>
                            </div>
                        </div>

                        <div class="metro-border fn-flex">
                            <div></div>
                            <div class="green"></div>
                            <div class="yellow"></div>
                            <div class="red"></div>
                            <div class="purple"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "footer.ftl">
    <script src="${staticServePath}/js/channel${miniPostfix}.js?${staticResourceVersion}"></script>
    <script type="text/javascript">
        $('.metro-item').height($('.metro-item').width());

        // tab
        $('#articles span').click(function () {
            var $it = $(this);
            $('#articles span').removeClass('current');
            $it.addClass('current');
            $it.addClass('current');

            $(".index-tabs-panels.article-list ul").hide();
            if ($it.hasClass('tags')) {
                $(".index-tabs-panels.article-list ul:eq(1)").show();
            } else if ($it.hasClass('users')) {
                $(".index-tabs-panels.article-list ul:eq(2)").show();
            } else {
                $(".index-tabs-panels.article-list ul:eq(0)").show();
            }

            localStorage.setItem('indexTab', $it.data('index'));
        });

        // tag click
        $('.preview, .index-tabs > span').click(function (event) {
            var $it = $(this),
            maxLen = Math.max($it.width(), $it.height());
            $it.prepend('<span class="ripple" style="top: ' + (event.offsetY - $it.height() / 2)
                + 'px;left:' + (event.offsetX - $it.width() / 2) + 'px;height:' + maxLen + 'px;width:' + maxLen + 'px"></span>');

            setTimeout(function () {
                $it.find('.ripple').remove();
            }, 800);
        });

        // set tab
        if (typeof(localStorage.indexTab) === 'string') {
            $('.index-tabs:first > span:eq(' + localStorage.indexTab + ')').click();
        } else {
            localStorage.setItem('indexTab', 0);
        }
    </script>
</body>
</html>
