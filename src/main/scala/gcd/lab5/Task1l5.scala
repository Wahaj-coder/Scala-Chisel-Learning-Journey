package lab5
import chisel3 . _
import chisel3 . util . _

class IOInterface ( width : Int ) extends Bundle {
    val in0 = Input ( UInt ( width . W ) )
    val in1 = Input ( UInt ( width . W ) )
    val sum = Output ( UInt ( width . W ) )}

class Task1l5 ( Width : Int ) extends Module {
    val io = IO ( new IOInterface ( Width))
    io.sum:= io.in0+io.in1
}