<!DOCTYPE HTML>
<html>
<head>
    <title>百度地图交通通勤图</title>
    <script>
        void function (g, f, j, c, h, d, b) {
            g.alogObjectName = h, g[h] = g[h] || function () {
                (g[h].q = g[h].q || []).push(arguments)
            }, g[h].l = g[h].l || +new Date, d = f.createElement(j), d.async = !0, d.src = c, b = f.getElementsByTagName(j)[0], b.parentNode.insertBefore(d, b)
        }(window, document, "script", "http://img.baidu.com/hunter/alog/alog.min.js", "alog");
        void function () {
            function c() {
                return;
            }

            window.PDC = {
                mark: function (a, b) {
                    alog("speed.set", a, b || +new Date);
                    alog.fire && alog.fire("mark")
                }, init: function (a) {
                    alog("speed.set", "options", a)
                }, view_start: c, tti: c, page_ready: c
            }
        }();
        void function (n) {
            var o = !1;
            n.onerror = function (n, e, t, c) {
                var i = !0;
                return !e && /^script error/i.test(n) && (o ? i = !1 : o = !0), i && alog("exception.send", "exception", {
                    msg: n,
                    js: e,
                    ln: t,
                    col: c
                }), !1
            }, alog("exception.on", "catch", function (n) {
                alog("exception.send", "exception", {msg: n.msg, js: n.path, ln: n.ln, method: n.method, flag: "catch"})
            })
        }(window);
    </script>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="http://jiaotong.baidu.com/static/nanjinghuiyizhongxin/style.css"/>
</head>
<script> alog('speed.set', 'ht', +new Date); </script>
<body>
<div id="map" class="map"></div>

<div id="nav-bar">
    <div class="nav-bar-logo"></div>
    <div class="nav-bar-title">城市OD分析平台</div>
</div>

<div class="aside">
    <div class="aside_title">南京通勤图</div>
    <div id="aside_list" class="aside_list">
        <!--
        <a class="current" href="javascript:void(0);" key=""><span>全市</span></a>
        -->
    </div>
</div>
<div class="loading">
    加载中......
</div>
<div class="tip" style="display:none;">
</div>

<div id="heatmapBox" class="heatmapBox showBox">
    <div class="tabBtn" target="#heatmapBox">南京市热力分布</div>
    <div class="smallMap" id="smallMap"></div>
    <div class="title">热力分布</div>
</div>

<div id="analysisPanel" class="analysisPanel showBox">
    <div class="tabBtn" target="#analysisPanel">人流画像</div>
    <div class="tabList">
        <div class="tab tab1 current">轮播</div>
        <div class="tab tab2" echarts="echarts_interest">兴趣偏好</div>
        <div class="tab tab3" echarts="echarts_gender">男女比例</div>
        <div class="tab tab4" echarts="echarts_community">来源小区 Top10</div>
    </div>
    <div class="tabCon">
        <div class="tabConItem" style="display:block;">
            <div class="echarts" id="echarts_interest"></div>
            <div class="title">兴趣偏好</div>
        </div>
        <div class="tabConItem">
            <div class="echarts" id="echarts_gender"></div>
            <div class="title">男女比例</div>
        </div>
        <div class="tabConItem">
            <div class="echarts" id="echarts_community"></div>
            <div class="title">来源小区</div>
        </div>
    </div>
</div>


<script type="text/javascript" src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=1XjLLEhZhQNUzd93EjU5nOGQ"></script>
<script type="text/javascript"
        src="http://jiaotong.baidu.com/static/nanjinghuiyizhongxin/echarts-plain-map.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>

<script type="text/javascript" src="http://jiaotong.baidu.com/static/nanjinghuiyizhongxin/MapMask.js"></script>
<script type="text/javascript" src="http://jiaotong.baidu.com/static/nanjinghuiyizhongxin/TrafficLayer.js"></script>
<script type="text/javascript" src="http://www.dzgj.com/js/transport/main.js"></script>

<!--百度统计-->
<div style="display:none;">
    <script type="text/javascript">
        var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
        document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F385212e40ed5d10f14eaf851758e1966' type='text/javascript'%3E%3C/script%3E"));
    </script>
</div>

</body>
</html>
<!--24127421730376098058081709-->
<script> var _trace_page_logid = 2412742173; </script>