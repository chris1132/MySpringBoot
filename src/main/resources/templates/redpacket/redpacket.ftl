<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>参数</title>
    <!-- 加载Query文件-->
    <script type="text/javascript" src="http://www.dzgj.com/js/love1/jquery.min.js"></script>
    </script>

    <
    body >
    < script
    type = "text/javascript" >
            $(document).ready(function () {
                //模拟30000个异步请求，进行并发
                var max = 30000;
                for (var i = 1; i <= max; i++) {
                    //jQuery的post请求，请注意这是异步请求
                    $.post({
                        //请求抢id为1的红包
                        //根据自己请求修改对应的url和大红包编号
                        url: "http://www.dzgj.com/userRedPacket/grapRedPacket?redPacketId=1&userId=" + i,
                        //成功后的方法
                        success: function (result) {
                        }
                    });
                }
            });
    </script>
</head>
<body>
</body>
</html>
