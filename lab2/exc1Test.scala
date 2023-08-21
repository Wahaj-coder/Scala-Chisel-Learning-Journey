package lab2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class  exc1Test extends FreeSpec with ChiselScalatestTester{
    "exc1 Tester file " in {
        test(new exc1){ a=>
      
        a.io.in_A.poke(6.U)
        a.io.in_B.poke(9.U)
        a.io.select.poke(0.B)
        a.clock.step()
        a.io.out.expect(6.U)
       
        }
    }
}