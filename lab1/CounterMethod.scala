package lab1
import chisel3._
import chisel3.util._

class CounterMethod( size : Int , maxValue : UInt) extends Module {
    val io = IO(new Bundle{   
       val result= Output(Bool()) 
    })
    def genCounter(n:Int, max:UInt)={

        val count=RegInit(0.U(n.W))
        
        when(count===max){
            count:=0.U
        }
        .otherwise{
            count:=count+1.U
        }
        count
}
    val counter1=genCounter(size,maxValue)
    io.result:= counter1(size-1)

}