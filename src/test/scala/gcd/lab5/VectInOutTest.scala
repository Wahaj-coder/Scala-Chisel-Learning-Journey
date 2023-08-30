package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class VectInOutTest extends FreeSpec with ChiselScalatestTester {
  "e3l5" in {
    test(new VectInOut(3, UInt(8.W))(_ + _)) { c =>
      // Set input values
      c.io.in(0).poke(5.U)
      c.io.in(1).poke(3.U)
      c.io.in(2).poke(3.U)
      
      // Step the clock
      c.clock.step()
      
      // Check output values
      c.io.out(0).expect(10.U)
      c.io.out(1).expect(6.U)
      c.io.out(2).expect(6.U)
    }
  }
}
