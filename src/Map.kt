class Map <Type1, Type2>(key: Type1, value: Type2){

    class node <Type1, Type2>(Key: Type1, Value:Type2){
        private val key = Key
        private var value = Value

        private var next: node<Type1, Type2>? = null

        @kotlin.Throws(Exception::class)
        fun createnext(Key: Type1, Value: Type2) {
            next = if (next == null) node<Type1, Type2>(key, value) else throw Exception("Value is not null")
        }

        fun setValue(value: Type2) {
            this.value = value
        }

        fun getKey(): Type1{
            return key

        }

        fun getValue(): Type2{
            return value

        }
        fun setNext(key: Type1, value:Type2){
            this.next = node(key,value)
        }

        fun getNext(): node<Type1, Type2>? {
            return this.next

        }
    }


    var base = node(key, value)

    var lastnode = base

    fun add(key: Type1, value: Type2){
        if(this.base == null){
            this.base = node<Type1, Type2>(key, value)

        }else{
            lastnode.setNext(key,value)

            lastnode = lastnode.getNext()!!

        }
    }

    private fun getValueInternal(key: Type1, node: node<Type1, Type2>): Type2? {
        //TODO using == could cause problems
       if(node.getKey()==key){
            return node.getValue()

        }else if(node.getNext() == null){
           return null

       }else{
            return getValueInternal(key, node.getNext()!!)
        }
    }


    fun getValue(key: Type1): Type2? {
        return getValueInternal(key, base)

    }


    fun getIndexOfKey(key: Type1): Int {
        return getIndexofKeyInternal(key, base, 0)

    }

    private fun getIndexofKeyInternal(key: Type1, node: node<Type1, Type2>, counter: Int): Int{
        if(node.getKey()==key){
            return counter
        }else if(node.getNext() == null){
            return -1

        }else{
            return getIndexofKeyInternal(key, node.getNext()!!, counter+1)
        }
    }

    fun getKeyUsingIndex(index: Int): Type1?{
        return getKeyInternalUsingIndex(index, base)
    }

    fun getKey(value: Type2): Type1?{
        return getKeyInternal(value, base)
    }

    fun  getKeyInternal(value: Type2, node: node<Type1, Type2>): Type1?{
        if(node.getValue() == value){
            return node.getKey()

        }else if(node.getNext() == null){
            return null

        }else{
            return  getKeyInternal(value, node.getNext()!!)

        }
    }

    private fun getKeyInternalUsingIndex(index: Int, node: node<Type1, Type2>): Type1?{
        if(index == 0){
            return node.getKey()

        }else if(node.getNext() == null){
            return  null

        }else{
            return getKeyInternalUsingIndex(index-1, node.getNext()!!)

        }
    }




    }

fun main(){
    var x = Map<String, String>("Lol", "Laugh out Loud")

    x.add("hbd", "Happy Birthday!")
    x.add("u", "you")
    println(x.getKey("Laugh out Loud"))
    println(x.getIndexOfKey("u"))
    println(x.getValue("hbd"))
    println(x.getKeyUsingIndex(0))

}
