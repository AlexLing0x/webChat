# webChat
Java 和 WebSocket实现网页聊天室，前端使用AmazeUI，后台Java，编辑器UMEditor。

WebSocket是什么？

WebSocket是HTML5开始提供的一种在单个 TCP 连接上进行全双工通讯的协议。 

在WebSocket API中，浏览器和服务器只需要做一个握手的动作，然后，浏览器和服务器之间就形成了一条快速通道。两者之间就直接可以数据互相传送。

浏览器通过 JavaScript 向服务器发出建立 WebSocket 连接的请求，连接建立以后，客户端和服务器端就可以通过 TCP 连接直接交换数据。

当你获取 Web Socket 连接后，你可以通过 send() 方法来向服务器发送数据，并通过 onmessage 事件来接收服务器返回的数据。

详细介绍 阮一峰的[WebSocket 教程](www.ruanyifeng.com/blog/2017/05/websocket.html)
