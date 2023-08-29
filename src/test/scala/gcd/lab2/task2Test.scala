// package lab2

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class  task2Test extends FreeSpec with ChiselScalatestTester{
//     "task2 Tester file " in {
//         test(new task2){ a=>
      
        
//         a.io.in0.poke(1.B)
//         a.io.in1.poke(0.B)
//         a.io.in2.poke(0.B)
//         a.io.in3.poke(0.B)
//         a.io.sel.poke(0.U)
//         a.io.shift.poke(0.B)
//         a.clock.step()
//         a.io.out0.expect(1.B)
//         a.io.out1.expect(0.B)
//         a.io.out2.expect(0.B)
//         a.io.out3.expect(0.B)

       
//         }
//     }
// }