package lab5
import chisel3._
import chisel3.util._

class IO_Interface ( width : Int ) extends Bundle {
    val aluOp = Input ( UInt ( width . W ) )
    val X = Input ( UInt ( width . W ) )
    val Y = Input ( UInt ( width . W ) )
    val out = Output ( UInt ( width . W ) )}


class ALUWhen ( width_parameter : Int ) extends Module {
    val io = IO ( new IO_Interface ( width_parameter ) )
    io.out := 0. U
    val index = log2Ceil ( width_parameter )

    when(io.aluOp===0.U){//AND
        io.out:=io.X & io.Y
    }.elsewhen(io.aluOp===1.U){//OR
        io.out:=io.X | io.Y
    }.elsewhen(io.aluOp===2.U){//ADD
        io.out:=io.X + io.Y
    }.elsewhen(io.aluOp===6.U){//SUB
        io.out:=io.X - io.Y
    }.elsewhen(io.aluOp===3.U){//XOR
        io.out:=io.X ^ io.Y
    }.elsewhen(io.aluOp===4.U){//SLL
        io.out:=io.X << io.Y( index -1 , 0)
    }.elsewhen(io.aluOp===5.U){//SRL
        io.out:=io.X >> io.Y( index -1 , 0)
    }.elsewhen(io.aluOp===7.U){///SRA
        io.out:= ( io.X.asSInt >> io.Y( index -1 , 0) ).asUInt
    }.elsewhen(io.aluOp===8.U){//SLT
        io.out:=io.X.asSInt < io.Y.asSInt
    }.elsewhen(io.aluOp===9.U){//SLTU
        io.out:=io.X < io.Y
    }
}


