package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class exc3l6Test extends FreeSpec with ChiselScalatestTester {
  "exc3l6" in {
    test(new exc3l6(4) ){ c =>   
        c.io.reload.poke(0.B)
        c.io.trigger.poke(0.B)
        c.io.din.poke(3.U)
        c.clock.step(3) // Advance the clock by 6 cycles
        c.io.out.expect(0.B) // Expect the output to be high during countdown

    }
  }
}
