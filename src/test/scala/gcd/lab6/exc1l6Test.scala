package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class PipoRegTest extends FreeSpec with ChiselScalatestTester {
  "taskPIPO" in {
    test(new PipoReg()) { c =>   
        c.io.parallelIn.poke(5.U)          
        c.clock.step()
        c.io.parallelOut.expect(4.U)

    }
  }
}
