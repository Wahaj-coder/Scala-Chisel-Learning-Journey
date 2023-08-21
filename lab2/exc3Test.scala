package lab2

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class  exc3Test extends FreeSpec with ChiselScalatestTester{
    "exc3 Tester file " in {
        test(new exc3){ a=>
      
        a.io.in.poke(8.U)
        a.io.select.poke(1.B)
        a.clock.step()
        a.io.out.expect(2.U)
       
        }
    }
}