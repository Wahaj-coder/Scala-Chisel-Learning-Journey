package lab5

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class  MuxTypeTest extends FreeSpec with ChiselScalatestTester{
    "e2l5 Tester file " in {
        test(new MuxType(UInt(32.W))){ a=>

        a.io.in1.poke(3.U)
        a.io.in2.poke(1.U)
        a.io.sel.poke(0.B)
        a.clock.step()
        a.io.out.expect(3.U)
       
        }
    }
}