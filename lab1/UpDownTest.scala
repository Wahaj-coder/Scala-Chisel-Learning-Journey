package lab1
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class UpDownTest extends FreeSpec with ChiselScalatestTester {
  "UpDownCounter test" in {
    test(new UpDown(4)) { dut =>
      // Reset the counter
      dut.io.reload.poke(true.B)
      dut.io.data_in.poke(0.U)
      dut.clock.step(1)
      dut.io.reload.poke(false.B)
      
      dut.io.data_in.poke(4.U)
      dut.clock.step(15)
    }
  }
}