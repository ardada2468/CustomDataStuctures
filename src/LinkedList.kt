class LinkedList<Type> {
    private var base: node? = null
    private var lastnode = base
    var lenght = 0

    constructor() {}

    constructor(list: Array<Type>) {
        for (type in list) {
            add(type)
        }
    }

    fun add(value: Type) {
        try {
            if (base == null) {
                base = node(null, value)
                lastnode = base
            } else {
                lastnode!!.createnext(value)
                lastnode = lastnode!!.next
            }
            lenght++
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun add(list: Array<Type>) {
        for (type in list) {
            add(type)
        }
    }

    private fun privateFindObj(x: Type, Node: node?, index: Int): Int {
        var index = index
        if (Node!!.value == x) {
            return index
        } else if (Node.next == null) {
            return -1
        }
        run { return privateFindObj(x, Node.next, index++) }
    }

    fun findIndexOf(value: Type): Int {
        return privateFindObj(value, base, 0)
    }

    private fun getNode(index: Int): node? {
        val Node = base
        return if (index == 0) {
            Node
        } else getNode(index - 1)
    }

    operator fun get(index: Int): Type? {
        return getNode(index)?.value
    }

    operator fun set(index: Int, Value: Type) {
        getNode(index)!!.setValue(Value)
    }

    internal inner class node {
        var next: node? = null
        var prev: node?
        var value: Type? = null
            private set

        constructor(prev: node?) {
            this.prev = prev
        }

        constructor(prev: node?, value: Type) {
            this.prev = prev
            this.value = value
        }

        @kotlin.Throws(Exception::class)
        fun createnext(value: Type) {
            next = if (next == null) node(this, value) else throw Exception("Value is not null")
        }

        fun setValue(value: Type) {
            this.value = value
        }
    }
}

fun main(){
   val list = LinkedList<String>();

    list.add("Hello World")
    println(list[0])
    list.set(0, "LMAO")
    println(list.get(0))

}