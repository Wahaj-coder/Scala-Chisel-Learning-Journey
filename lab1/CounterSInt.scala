package lab1
import chisel3._
import chisel3.util._

class CounterSInt( counterBits : SInt ) extends Module {
    val io = IO(new Bundle{   
       val out = Output(SInt()) 
    })

    val max = (counterBits)
    
    var count = RegInit ((-3.S(16.W) ))

    when ( (count)=== (max)) {
        count:= (0.S)
    } .otherwise {
        count := count + 1.S
        }

    io.out:=count
    println ( s" counter created with max value $max" )   
    println(count) 
}