package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class SIPOShiftTest extends FreeSpec with ChiselScalatestTester {
  "taskSIPO" in {
    test(new SIPOShift()) { c =>   
        c.io.serialIn.poke(1.B)          
        c.clock.step()
        c.io.parallelOut.expect(1.U)

         c.io.serialIn.poke(1.B)          
        c.clock.step()
        c.io.parallelOut.expect(3.U)

         c.io.serialIn.poke(0.B)          
        c.clock.step()
        c.io.parallelOut.expect(6.U)

    }
  }
}