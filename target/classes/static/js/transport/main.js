function radiusChangeByZoom(e) {
    var t = 2;
    switch (e) {
        case 11:
            t = 3;
            break;
        case 12:
            t = 4;
            break;
        case 13:
            t = 8;
            break;
        case 14:
            t = 11;
            break;
        case 15:
            t = 13;
            break;
        case 16:
            t = 13;
            break;
        case 17:
            t = 13;
            break;
        case 18:
            t = 13;
            break;
        case 19:
            t = 13
    }
    return t
}

function AnimateMarker(e, t) {
    this._point = e,
        this.text = t
}

function getDataByKey(e) {
    $.ajax({
        url: "./api/" + e + "/interest",
        dataType: "JSON",
        success: function (e) {
            var t = [],
                a = [];
            for (var i in e) t.push(i),
                a.push(~~e[i].weight);
            var n = "echarts_interest";
            echarts_option[n].xAxis[0].data = t,
                echarts_option[n].series[0].data = a,
                echarts_instant[n].setOption(echarts_option[n])
        }
    }),
        $.ajax({
            url: "./api/" + e + "/userpic",
            dataType: "JSON",
            success: function (e) {
                e = e.gender,
                    flag = !0;
                var t = [],
                    a = [];
                for (var i in e) a.push(i),
                    t.push({
                        value: ~~e[i],
                        name: i
                    });
                var n = "echarts_gender";
                echarts_option[n].series[0].data = t,
                    echarts_option[n].legend.data = a,
                    echarts_instant[n].setOption(echarts_option[n])
            }
        }),
        $.ajax({
            url: "./api/" + e + "/community",
            success: function (e) {
                e = e.split("\n");
                for (var t = [], a = [], i = 0; i < e.length; i++) e[i] = e[i].split("	"),
                    t.push(e[i][0]),
                    a.push(~~e[i][1]);
                var n = "echarts_community";
                echarts_option[n].xAxis[0].data = t,
                    echarts_option[n].series[0].data = a,
                    echarts_instant[n].setOption(echarts_option[n])
            }
        })
}

function animateAction() {
    if (flag) {
        $(".tabCon .tabConItem").hide(),
            $(".tabCon .tabConItem").eq(animateIndex).show();
        var e = $(".tabList .tab").eq(animateIndex + 1).attr("echarts");
        echarts_instant[e].clear(),
            echarts_instant[e].resize(),
            echarts_instant[e].setOption(echarts_option[e]),
            animateIndex++,
        animateIndex > 2 && (animateIndex = 0)
    }
    setTimeout(arguments.callee, 1e4)
}

var animateCount = 300,
    workPlaces = {
        nanjinghuiyizhongxin: {
            name: "金陵会议中心",
            strokeStyle: "rgba(255,58,53,0.9)",
            lineWidth: .1,
            center: new BMap.Point(118.718047, 31.996774)
        },
        fuzimiao: {
            name: "夫子庙",
            strokeStyle: "rgba(69,178,255,1)",
            lineWidth: .1,
            center: new BMap.Point(118.79643017078736, 32.02740563037541)
        },
        xinjiekou: {
            name: "新街口",
            strokeStyle: "rgba(190,190,14,1)",
            lineWidth: .1,
            center: new BMap.Point(118.789639, 32.047126)
        },
        xuanwuhu: {
            name: "玄武湖",
            strokeStyle: "rgba(0,240,243,0.9)",
            lineWidth: .1,
            center: new BMap.Point(118.799421, 32.077482)
        }
    },
    allKeys = [];
for (var key in workPlaces) allKeys.push(key);
for (var key in workPlaces) $("#aside_list").append('<a href="javascript:void(0);" key="' + key + '"><b style="background:' + workPlaces[key].strokeStyle + '"></b><span>' + workPlaces[key].name + "</span></a>");
var map = new BMap.Map("map", {
    maxZoom: 16,
    vectorMapLevel: 19,
    enableMapClick: !1
});
map.setMinZoom(11),
    map.getContainer().style.background = "#081734",
    map.setMapStyle({
        styleJson: [{
            featureType: "water",
            elementType: "all",
            stylers: {
                color: "#044161"
            }
        },
            {
                featureType: "land",
                elementType: "all",
                stylers: {
                    color: "#091934"
                }
            },
            {
                featureType: "boundary",
                elementType: "geometry",
                stylers: {
                    color: "#064f85"
                }
            },
            {
                featureType: "railway",
                elementType: "all",
                stylers: {
                    visibility: "off"
                }
            },
            {
                featureType: "highway",
                elementType: "geometry",
                stylers: {
                    color: "#004981"
                }
            },
            {
                featureType: "highway",
                elementType: "geometry.fill",
                stylers: {
                    color: "#005b96",
                    lightness: 1
                }
            },
            {
                featureType: "highway",
                elementType: "labels",
                stylers: {
                    visibility: "on"
                }
            },
            {
                featureType: "arterial",
                elementType: "geometry",
                stylers: {
                    color: "#004981",
                    lightness: -39
                }
            },
            {
                featureType: "arterial",
                elementType: "geometry.fill",
                stylers: {
                    color: "#00508b"
                }
            },
            {
                featureType: "poi",
                elementType: "all",
                stylers: {
                    visibility: "on"
                }
            },
            {
                featureType: "green",
                elementType: "all",
                stylers: {
                    color: "#056197",
                    visibility: "off"
                }
            },
            {
                featureType: "subway",
                elementType: "all",
                stylers: {
                    visibility: "off"
                }
            },
            {
                featureType: "manmade",
                elementType: "all",
                stylers: {
                    visibility: "off"
                }
            },
            {
                featureType: "local",
                elementType: "all",
                stylers: {
                    visibility: "off"
                }
            },
            {
                featureType: "arterial",
                elementType: "labels",
                stylers: {
                    visibility: "off"
                }
            },
            {
                featureType: "boundary",
                elementType: "geometry.fill",
                stylers: {
                    color: "#029fd4"
                }
            },
            {
                featureType: "building",
                elementType: "all",
                stylers: {
                    color: "#1a5787"
                }
            },
            {
                featureType: "label",
                elementType: "all",
                stylers: {
                    visibility: "off"
                }
            },
            {
                featureType: "poi",
                elementType: "labels.text.fill",
                stylers: {
                    color: "#ffffff"
                }
            },
            {
                featureType: "poi",
                elementType: "labels.text.stroke",
                stylers: {
                    color: "#1e1c1c"
                }
            }]
    });
var defaultKey = "nanjinghuiyizhongxin";
map.centerAndZoom(workPlaces[defaultKey].center, 12),
    map.panBy(-$(".heatmapBox").width() / 2, 0),
    map.enableScrollWheelZoom();
var smallMap = new BMap.Map("smallMap", {
    enableMapClick: !1
});
smallMap.setMapStyle({
    styleJson: [{
        featureType: "water",
        elementType: "all",
        stylers: {
            color: "#044161"
        }
    },
        {
            featureType: "land",
            elementType: "all",
            stylers: {
                color: "#091934"
            }
        },
        {
            featureType: "boundary",
            elementType: "geometry",
            stylers: {
                color: "#064f85"
            }
        },
        {
            featureType: "railway",
            elementType: "all",
            stylers: {
                visibility: "off"
            }
        },
        {
            featureType: "highway",
            elementType: "geometry",
            stylers: {
                color: "#004981"
            }
        },
        {
            featureType: "highway",
            elementType: "geometry.fill",
            stylers: {
                color: "#005b96",
                lightness: 1
            }
        },
        {
            featureType: "highway",
            elementType: "labels",
            stylers: {
                visibility: "on"
            }
        },
        {
            featureType: "arterial",
            elementType: "geometry",
            stylers: {
                color: "#004981",
                lightness: -39
            }
        },
        {
            featureType: "arterial",
            elementType: "geometry.fill",
            stylers: {
                color: "#00508b"
            }
        },
        {
            featureType: "poi",
            elementType: "all",
            stylers: {
                visibility: "on"
            }
        },
        {
            featureType: "green",
            elementType: "all",
            stylers: {
                color: "#056197",
                visibility: "off"
            }
        },
        {
            featureType: "subway",
            elementType: "all",
            stylers: {
                visibility: "off"
            }
        },
        {
            featureType: "manmade",
            elementType: "all",
            stylers: {
                visibility: "off"
            }
        },
        {
            featureType: "local",
            elementType: "all",
            stylers: {
                visibility: "off"
            }
        },
        {
            featureType: "arterial",
            elementType: "labels",
            stylers: {
                visibility: "off"
            }
        },
        {
            featureType: "boundary",
            elementType: "geometry.fill",
            stylers: {
                color: "#029fd4"
            }
        },
        {
            featureType: "building",
            elementType: "all",
            stylers: {
                color: "#1a5787"
            }
        },
        {
            featureType: "label",
            elementType: "all",
            stylers: {
                visibility: "off"
            }
        }]
}),
    smallMap.getContainer().style.background = "#081734",
    smallMap.centerAndZoom(workPlaces.nanjinghuiyizhongxin.center, 11),
    smallMap.enableScrollWheelZoom(),
    smallMap.setMinZoom(11);
var heatmapOverlay = new BMapLib.HeatmapOverlay({
    radius: 9,
    radiusChangeByZoom: radiusChangeByZoom,
    maxOpacity: .6
});
smallMap.addOverlay(heatmapOverlay);
var trafficLayer = new TrafficLayer({
    map: map
});
for (var key in workPlaces) trafficLayer.setStyle(key, {
    strokeStyle: workPlaces[key].strokeStyle,
    lineWidth: workPlaces[key].lineWidth
});
AnimateMarker.prototype = new BMap.Overlay,
    AnimateMarker.prototype.initialize = function (e) {
        this._map = e;
        var t = this._div = document.createElement("div");
        t.className = "animateMarker",
            t.innerHTML = this.text;
        return e.getPanes().labelPane.appendChild(t),
            t
    },
    AnimateMarker.prototype.show = function () {
        $(this._div).css("opacity", 1)
    },
    AnimateMarker.prototype.fadeOut = function () {
        var e = this;
        this._inAnimate || (this._inAnimate = !0, requestAnimationFrame(function () {
            e.animateFadeOut()
        }))
    },
    AnimateMarker.prototype.animateFadeOut = function () {
        var e = this,
            t = $(this._div).css("opacity");
        t -= .01,
            $(this._div).css("opacity", t),
            t > .01 ? requestAnimationFrame(function () {
                e.animateFadeOut()
            }) : this._inAnimate = !1
    },
    AnimateMarker.prototype.draw = function () {
        var e = this._map,
            t = e.pointToOverlayPixel(this._point);
        this._div.style.left = t.x - 50 + "px",
            this._div.style.top = t.y - 50 + "px"
    },
    AnimateMarker.prototype.setPointAndText = function (e, t) {
        this._point = e,
            this._div.innerHTML = t,
            this.draw()
    },
    trafficLayer.show([defaultKey]),
    $('#aside_list a[key="' + defaultKey + '"]').addClass("current"),
    $('#aside_list a[key="' + defaultKey + '"]').addClass("current");
var animateMarker = new AnimateMarker(workPlaces[defaultKey].center, workPlaces[defaultKey].name);
map.addOverlay(animateMarker),
    setTimeout(function () {
            animateMarker.fadeOut()
        },
        2e3),
    $("#aside_list").delegate("a", "click",
        function () {
            var e = ($(this).html(), $(this).attr("key")),
                t = workPlaces[e];
            getDataByKey(e),
                $("#aside_list a").removeClass("current"),
                $(this).addClass("current"),
                e ? (trafficLayer.show([e]), animateMarker.show(), animateMarker.setPointAndText(t.center, t.name), smallMap.setCenter(t.center), setTimeout(function () {
                        animateMarker.fadeOut()
                    },
                    2e3), map.centerAndZoom(t.center, 12)) : (trafficLayer.show(allKeys), map.centerAndZoom(new BMap.Point(116.404, 39.915), 12))
        }),
    $(".aside_title").bind("touchend",
        function () {
            $("#aside_list").toggle("quick")
        });
var WXurl = "http://renqi.baidu.com/traffic",
    WXtitle = "百度地图交通通勤图",
    WXdec = "百度地图交通通勤图",
    dataForWeixin = {
        appId: "",
        MsgImg: "http://renqi.baidu.com/traffic/weixin.png",
        TLImg: "http://renqi.baidu.com/traffic/weixin.png",
        url: WXurl,
        title: WXtitle,
        desc: WXdec,
        fakeid: "",
        callback: function () {
        }
    };
!
    function () {
        var e = function () {
            WeixinJSBridge.on("menu:share:appmessage",
                function () {
                    WeixinJSBridge.invoke("sendAppMessage", {
                            appid: dataForWeixin.appId,
                            img_url: dataForWeixin.MsgImg,
                            img_width: "120",
                            img_height: "120",
                            link: dataForWeixin.url,
                            desc: dataForWeixin.desc,
                            title: dataForWeixin.title
                        },
                        function () {
                            dataForWeixin.callback()
                        })
                }),
                WeixinJSBridge.on("menu:share:timeline",
                    function () {
                        dataForWeixin.callback(),
                            WeixinJSBridge.invoke("shareTimeline", {
                                    img_url: dataForWeixin.TLImg,
                                    img_width: "120",
                                    img_height: "120",
                                    link: dataForWeixin.url,
                                    desc: dataForWeixin.desc,
                                    title: dataForWeixin.title
                                },
                                function () {
                                })
                    }),
                WeixinJSBridge.on("menu:share:weibo",
                    function () {
                        WeixinJSBridge.invoke("shareWeibo", {
                                content: dataForWeixin.title,
                                url: dataForWeixin.url
                            },
                            function () {
                                dataForWeixin.callback()
                            })
                    }),
                WeixinJSBridge.on("menu:share:facebook",
                    function () {
                        dataForWeixin.callback(),
                            WeixinJSBridge.invoke("shareFB", {
                                    img_url: dataForWeixin.TLImg,
                                    img_width: "120",
                                    img_height: "120",
                                    link: dataForWeixin.url,
                                    desc: dataForWeixin.desc,
                                    title: dataForWeixin.title
                                },
                                function () {
                                })
                    })
        };
        document.addEventListener ? document.addEventListener("WeixinJSBridgeReady", e, !1) : document.attachEvent && (document.attachEvent("WeixinJSBridgeReady", e), document.attachEvent("onWeixinJSBridgeReady", e))
    }();
var echarts_instant = {
        echarts_interest: echarts.init(document.getElementById("echarts_interest")),
        echarts_gender: echarts.init(document.getElementById("echarts_gender")),
        echarts_community: echarts.init(document.getElementById("echarts_community"))
    },
    echarts_option = {
        echarts_interest: {
            tooltip: {
                trigger: "axis"
            },
            toolbox: {
                show: !1,
                feature: {
                    mark: {
                        show: !0
                    },
                    dataView: {
                        show: !0,
                        readOnly: !1
                    },
                    magicType: {
                        show: !0,
                        type: ["line", "bar"]
                    },
                    restore: {
                        show: !0
                    },
                    saveAsImage: {
                        show: !0
                    }
                }
            },
            calculable: !0,
            xAxis: [{
                type: "category",
                data: [],
                splitLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                axisLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                axisLabel: {
                    rotate: 45,
                    textStyle: {
                        fontWeight: "bold",
                        color: "#fff"
                    },
                    clickable: !1
                }
            }],
            yAxis: [{
                type: "value",
                axisLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                splitLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                axisLabel: {
                    textStyle: {
                        color: "#fff"
                    }
                }
            }],
            series: [{
                name: "用户兴趣",
                type: "bar",
                data: []
            }]
        },
        echarts_gender: {
            legend: {
                orient: "vertical",
                textStyle: {
                    color: "#fff"
                },
                x: "10",
                y: "10",
                data: []
            },
            series: [{
                name: "男女比例",
                type: "pie",
                radius: "55%",
                center: ["50%", "50%"],
                data: []
            }]
        },
        echarts_community: {
            tooltip: {
                trigger: "axis"
            },
            toolbox: {
                show: !1,
                feature: {
                    mark: {
                        show: !0
                    },
                    dataView: {
                        show: !0,
                        readOnly: !1
                    },
                    magicType: {
                        show: !0,
                        type: ["line", "bar"]
                    },
                    restore: {
                        show: !0
                    },
                    saveAsImage: {
                        show: !0
                    }
                }
            },
            calculable: !0,
            xAxis: [{
                type: "category",
                data: [],
                splitLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                axisLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                axisLabel: {
                    rotate: 45,
                    textStyle: {
                        fontWeight: "bold",
                        color: "#fff"
                    },
                    clickable: !1
                }
            }],
            yAxis: [{
                type: "value",
                axisLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                splitLine: {
                    lineStyle: {
                        width: 0
                    }
                },
                axisLabel: {
                    textStyle: {
                        color: "#fff"
                    }
                }
            }],
            series: [{
                name: "来源小区",
                type: "bar",
                data: []
            }]
        }
    };
getDataByKey("nanjinghuiyizhongxin"),
    $.ajax({
        url: "http://huiyan.baidu.com/huiyan/api/heatmap/?file=nanjing_17_2015032614&callback=?",
        dataType: "JSON",
        success: function (e) {
            e = JSON.parse(e);
            for (var t = [], a = 0; a < e.length; a++) t.push({
                lng: e[a][0],
                lat: e[a][1],
                count: e[a][2]
            });
            heatmapOverlay.setDataSet({
                data: t,
                max: 8
            })
        }
    }),
    $(".tabList .tab").bind("click",
        function () {
            $(".tabList .tab").removeClass("current"),
                $(this).addClass("current");
            var e = $(this).attr("echarts");
            if ($(".tabCon .tabConItem").hide(), e) $("#" + e).parent().show(),
                echarts_instant[e].clear(),
                echarts_instant[e].resize(),
                echarts_instant[e].setOption(echarts_option[e]),
                flag = !1;
            else {
                flag = !0;
                var e = $(".tabList .tab").eq(1).attr("echarts");
                $(".tabCon .tabConItem").eq(0).show(),
                    echarts_instant[e].clear(),
                    echarts_instant[e].resize(),
                    echarts_instant[e].setOption(echarts_option[e])
            }
        });
var animateIndex = 1,
    flag = !1;
animateAction(),
    $(".tabBtn").bind("click",
        function () {
            var e = $(this).attr("target");
            $(this).siblings().each(function () {
                $($(this).attr("target")).hide()
            }),
                $(e).toggleClass("showBox")
        });