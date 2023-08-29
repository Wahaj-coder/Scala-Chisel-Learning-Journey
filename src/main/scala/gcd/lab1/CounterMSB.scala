package lab1
import chisel3._
import chisel3.util._

class CounterMSB( size : Int )extends Module {
    val io = IO(new Bundle{   
       val out = Output(UInt()) 
    })

    val maxVal= log2Ceil(size)
    var count = RegInit ((0.U(16.W) ))
    val msb= (1 << maxVal) - 1
    
  when(count(msb) === 1.U ) {
        count:= (0.U)
    } .otherwise {
        count := count + 1.U
        }

    io.out:=count   
}