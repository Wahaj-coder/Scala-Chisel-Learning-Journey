// package lab3

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class  exc1l3Test extends FreeSpec with ChiselScalatestTester{
//     "e1l3 Tester file " in {
//         test(new exc1l3){ a=>

//         a.io.inp.poke(8.U)
        
//         a.clock.step()
//         a.io.out.expect(3.U)
       
//         }
//     }
// }