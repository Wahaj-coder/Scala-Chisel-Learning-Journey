package lab2
import chisel3 . _
import chisel3 . util . _
class task2 extends Module {
    val io = IO ( new Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val sel= Input ( UInt(2.W))
val shift= Input ( Bool () )
val out0= Output(Bool())
val out1= Output(Bool())
val out2= Output(Bool())
val out3= Output(Bool())

})

val s0= Mux(io.shift,false.B,io.in0)
val s1= Mux(io.shift,false.B,io.in1)
val s2=Mux(io.shift,false.B,io.in2)

io . out0 := MuxLookup ( io.sel , false .B , Array (
(0. U ) -> io . in0 ,
(1. U ) -> io . in1 ,
(2. U ) -> io . in2 ,
(3. U ) -> io . in3 ))

io . out1 := MuxLookup ( io.sel , false .B , Array (
(0. U ) -> io . in1 ,
(1. U ) -> io . in2 ,
(2. U ) -> io . in3 ,
(3. U ) -> s0))

io . out2 := MuxLookup ( io.sel , false .B , Array (
(0. U ) -> io . in2,
(1. U ) -> io . in3 ,
(2. U ) -> s0 ,
(3. U ) -> s1))

io . out3 := MuxLookup ( io.sel , false .B , Array (
(0. U ) -> io . in3 ,
(1. U ) -> s0,
(2. U ) -> s1 ,
(3. U ) -> s2))

}
