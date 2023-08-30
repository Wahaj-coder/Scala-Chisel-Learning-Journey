package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class RouterTest extends FreeSpec with ChiselScalatestTester {
  "Routerl5 Test" in {
    test(new Router(UInt(32.W))) { c =>
      // Set input values
      c.io.in.data.poke(42.U)
      c.io.in.address.poke(123.U)
      
      // Step the clock
      c.clock.step()
      
      // Check output values
      c.io.out.data.expect(42.U)
      c.io.out.address.expect(123.U)
    }
  }
}
