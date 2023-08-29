// package lab2

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class  task1Test extends FreeSpec with ChiselScalatestTester{
//     "task Tester file " in {
//         test(new task1){ a=>
      
        
//         a.io.s0.poke(1.B)
//         a.io.s1.poke(1.B)
//         a.io.s2.poke(1.B)
//         a.clock.step()
//         a.io.out.expect(32.U)
       
//         }
//     }
// }