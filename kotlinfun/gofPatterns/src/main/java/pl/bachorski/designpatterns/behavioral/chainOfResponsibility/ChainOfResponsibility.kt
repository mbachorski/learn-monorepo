package pl.bachorski.designpatterns.behavioral.chainOfResponsibility

// Define a chain of Handler objects having the responsibility to either
// handle a request or forward it to the next handler.
// A class sends a request to a chain of handlers
// and doesn't know (is independent of) which handler handles the request.

interface HandlerResultCallback {
    fun onChainFinishedProcessing(result: String)
}

abstract class Handler(private val resultCallback: HandlerResultCallback) {
    var successor: Handler? = null

    abstract fun canHandleRequest(): Boolean

    open fun handleRequest(request: String) {
        if (successor == null) {
            resultCallback.onChainFinishedProcessing(request)
        } else {
            successor!!.handleRequest(request)
        }
    }
}

class Handler1(private val resultCallback: HandlerResultCallback) : Handler(resultCallback) {
    override fun canHandleRequest() = true

    override fun handleRequest(request: String) {
        super.handleRequest(request + "_handler1_")
    }
}

class Handler2(private val resultCallback: HandlerResultCallback) : Handler(resultCallback) {
    override fun canHandleRequest() = false

    override fun handleRequest(request: String) {
        super.handleRequest(if (canHandleRequest()) (request + "_handler2_") else request)
    }
}

class Handler3(private val resultCallback: HandlerResultCallback) : Handler(resultCallback) {
    override fun canHandleRequest() = true
    override fun handleRequest(request: String) {
        super.handleRequest(request + "_handler3_")
    }
}