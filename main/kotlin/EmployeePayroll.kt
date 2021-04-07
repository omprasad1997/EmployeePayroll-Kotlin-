import kotlin.math.floor

const val IS_PART_TIME = 1;
const val IS_FULL_TIME = 2;
const val PART_TIME_HOURS = 4;
const val FULL_TIME_HOURS = 8;
const val WAGE_PER_HOUR   = 20;
const val MAX_HRS_IN_MONTH = 160;
const val NUM_OF_WORKING_DAYS = 20;
var totalEmpHrs = 0;
var totalWorkingDays = 0;

fun main(){

    var empDailyWageArr = mutableListOf<Int>()

    while (totalEmpHrs <= MAX_HRS_IN_MONTH &&
            totalWorkingDays < NUM_OF_WORKING_DAYS){
        totalWorkingDays++;
        var empCheck = floor(Math.random()*10) %3
        var empHrs = getWorkingHours(empCheck.toInt())
        totalEmpHrs += empHrs
        empDailyWageArr.add(calcDailyWage(empHrs))
    }

    println("Total Emp Wage: " + empDailyWageArr.sum())
    println("Total Emp Wage with reduce function: " + empDailyWageArr.reduce { acc, value -> value + acc})
    println("Employee With daily Wage ")
    var dailyCntr = 0
     empDailyWageArr.map {
        dailyCntr++
        println("$dailyCntr : $it")
    }

    var fullDayWageArr = empDailyWageArr.filter {
        it == 160
    }
    println("Full time wage earned: ")
    println(fullDayWageArr)
    println("No of Days employee worked : ${noOfDaysCalculate( empDailyWageArr)}")
}

fun noOfDaysCalculate(empDailyWageArr: MutableList<Int>): Int {
    var days = 0;
    for(employeeWage in empDailyWageArr){
        if(employeeWage>0)
            days++
    }
    return days++
}

fun calcDailyWage(empHrs: Int): Int {
    return empHrs*WAGE_PER_HOUR
}

fun getWorkingHours(empCheck: Int): Int {
    return when(empCheck){
        IS_PART_TIME -> PART_TIME_HOURS
        IS_FULL_TIME -> FULL_TIME_HOURS
        else -> 0
    }
}




