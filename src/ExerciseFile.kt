import kotlin.math.pow
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    var choice: Int = 0
    while (choice != -1)
    {
        println("Welcome to Kotlin World")
        println("Please enter your choice")
        println("Enter 1 to Check whether a number is an Armstrong Number")
        println("Enter 2 to Check whether a List contains another List as a Sub List")
        println("Enter 3 to Check whether a given year is a Leap Year")
        println("Enter 4 reverse a string")
        println("Enter 5 to count the occurrence of each word in a string")
        println("Press -1 to Exit")
        choice = readLine()!!.toInt()
        when (choice) {
            1 -> {
                println("Please enter a number")
                var iNumber: Int = readLine()!!.toInt()
                if (isArmstrong(iNumber))
                    println("The number $iNumber is an ArmStrong Number")
                else
                    println("The number $iNumber is not an ArmStrong Number")
            }
            2 -> {
                var listA = mutableListOf<Int>()
                var listB = mutableListOf<Int>()
                println("Please enter size of list A")
                var iSize = readLine()!!.toInt()
                println("Enter elements of list A")
                while (iSize > 0) {
                    listA.add(readLine()!!.toInt())
                    iSize--
                }
                println("Please enter size of list B")
                iSize = readLine()!!.toInt()
                println("Enter elements of list B")
                while (iSize > 0) {
                    listB.add(readLine()!!.toInt())
                    iSize--
                }
                isSuperlist(listA, listB)
            }
            3 -> {
                println("Please enter a Valid Year")
                var iYear: Int = readLine()!!.toInt()
                if (isLeapYear(iYear))
                    println("The Year $iYear is a Leap Year")
                else
                    println("The Year $iYear is not a Leap Year")
            }
            4 -> {
                println("Please enter a Sentence to count the occurrence of each word")
                var iSen: String = readLine().toString()
                countOccurrence(iSen)
            }
            5 -> {
                println("Please enter a String to be reversed")
                var iStr: String = readLine().toString()
                println("Reverse String is ${reverseString(iStr)}")
            }
            -1 -> exitProcess(0)
            else -> println("Please enter valid choice")
        }
}
}
fun isArmstrong(number:Int):Boolean{
    //Count Number of digits in a number
    val noOfDigits = number.toString().length
    var temp = number
    var rem = 0
    var result = 0
    while(temp > 0){
        rem = temp %  10
        result += rem.toDouble().pow(noOfDigits).toInt()
        temp /= 10
    }
    return result==number?:false
}
fun isSuperlist(listA:List<Int>,listB:List<Int>)
{
    //Check if ListA is equal to ListB
    if(listA.size == listB.size)
    {
        var isEqual = true
        listA.forEachIndexed lit@ { index, value -> if (listB[index] != value) { isEqual = false; return@lit } }
        if(isEqual)
            print("ListA is equal to ListB")
        else
            print("List A is not a Super List,Sub List or Equal to List B")
    }
    else
    {
        //Check if List A is a superlist of List B
        if(listA.size>listB.size){
               var isSuperList = true;
               var subListIndex = listA.indexOf(listB[0])
               if(listA.size-subListIndex-1 >= listB.size)
                   listA.subList(subListIndex,listB.size-1).forEachIndexed outer@{ index, value -> if (listB[index] != value) { isSuperList = false; return@outer } }
               if(isSuperList)
                   println("List A is a Super List of List B")
               else
                   println("List A is not a Super List,Sub List or Equal to List B")
           }
        //Check if List A is a sublist of List B
        else
           {
               var isSubList = true
               var subListIndex = listB.indexOf(listA[0])
               if(listB.size-subListIndex-1 >= listA.size)
                   listB.subList(subListIndex,listA.size-1).forEachIndexed outer@{ index, value -> if (listA[index] != value) {isSubList = false; return@outer }}
                   if(isSubList)
                       println("List A is a Sub List of List B")
                   else
                       println("List A is not a Super List,Sub List or Equal to List B")
               }
           }
    }
fun isLeapYear(year:Int):Boolean{
    return if(year%4==0){
        if(year%100==0){
            year%400==0
        }else true
    }else false
}
fun countOccurrence(sentence:String){
    sentence.split(" ").map {
        object{
            val word = it
            val length = it.length
        }
    }.forEach{
        println("${it.word}:${it.length}")
    }
}
fun reverseString(str:String):String{
    var reverseString = ""
    for(i in str.length-1 downTo 0)
        reverseString += str[i]
    return reverseString
}