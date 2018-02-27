package chapter2

import chapter1.isEven

fun highOrderFunc(a:Int, validityCheckFunc:(a:Int)->Boolean) {//(1)
    if(validityCheckFunc(a)) {//(2)
        println("a $a is Valid")
    } else {
        println("a $a is Invalid")
    }
}

fun main(args: Array<String>) {
    highOrderFunc(12,{ a:Int -> a.isEven()})//(3)
    highOrderFunc(19,{ a:Int -> a.isEven()})

    val a = listOf(1,2,3,5).map { a -> a*a }.filter { a->isEven(a) }
    println(a)


    val mutableMapOf = mutableMapOf<Int, String>()
    mutableMapOf.put(1,"Zuda")
    mutableMapOf.put(2,"Apple")

    mutableMapOf.entries.forEach { (k,v) -> println(k) }

    val mutableMapOf2 = mutableMapOf<Int, String>()
    mutableMapOf2.put(2,"Apple")
    mutableMapOf2.put(1,"Zuda")
    mutableMapOf2.entries.forEach { (k,v) -> println(k) }



    println(mutableMapOf.equals(mutableMapOf2))






}


inline fun Int.isEven():Boolean = (this%2)==0


