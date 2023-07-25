package cuit.ljzhang.common.exception;

import lombok.NoArgsConstructor;

/**
 * @EnumName BStatusCodeEnume
 * @Description
 * @Author ljzhang
 * @Date 2023/7/21 17:15
 * @Version 1.0
 * 错误码列表
 * 2xx
 * 200 OK：从客户端发来的请求在服务器端被正常处理了，实体的主体部分包含了所请求的资源。
 * 201 Created：用于创建服务器对象的请求(比如：PUT)
 * 202 Accepted：请求已经被接收，但服务器还没有执行任何操作。
 * 3xx
 * 301 Moved Permanently：永久性重定向。该状态码表示请求的资源已被分配了新的 URI
 * 302 Found：临时性重定向。该状态码表示请求的资源已被分配了新的 URI
 * 4xx
 * 400 Bad Request：该状态码表示请求报文中存在语法错误。
 * 401 Unauthorized：告诉客户端，要想获取资源的访问权，首先要对自己认证。
 * 402 Payment Required：此状态码还未被使用，保留中。
 * 403 Forbidden：表明服务器拒绝了这个来自客户端的请求。已登录，但是没有权限
 * 404 Not Found：表明服务器上无法找到请求的资源。
 * 405 Method Not Allowed：客户端发起的请求中带有所有请求的URL不支持的方法。
 * 5xx
 * 500 Internal Server Error：该状态码表明服务器端在执行请求时遇到了一个妨碍它为请求提供服务的错误，也有可能是 Web 应用存在的 bug 或某些临时的故障。
 * 501 Not Implemented：客户端发起的请求超出服务器的能力范围(比如使用了服务器不支持的请求方法)
 * 502 Bad Gateway：作为代理或网关使用的服务器从请求响应链的下一条链路上受到了一条伪响应(比如，它无法连接到其他父网关)时，使用此码。
 * 503 Service Unavailable：该状态码表明服务器暂时处于超负载或正在进行停机维护，现在无法处理请求，但是将来可以。如果服务器知道什么时候能回复，可以在响应首部中添加Retry-After
 * 504 Gateway Timeout：与408类似，只是这里的响应来自一个网关或者代理，他们等待另一个服务器对齐请求进行响应超时了。
 */
@NoArgsConstructor
public enum BStatusCode {
    INTERNAL_SERVER_ERROR(500, "系统未知错误"),
    BAD_REQUEST(400,  "参数格式校验失败");

    private int code;
    private String msg;

    BStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
