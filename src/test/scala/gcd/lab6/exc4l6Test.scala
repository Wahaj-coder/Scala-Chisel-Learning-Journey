package lab6
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class exc4l6Test extends FreeSpec with ChiselScalatestTester {
  "exc4l6" in {
    test(new M1){ c =>   

      // Enqueue the first data element to M1
      c.io.in.valid.poke(true.B)
      c.io.in.bits.poke(1.U)
      c.io.out.ready.poke(true.B)
      c.clock.step(1)

      // Enqueue the first data element to M1
      c.io.in.valid.poke(true.B)
      c.io.in.bits.poke(2.U)
      c.io.out.ready.poke(true.B)
      c.clock.step(1)

      // Dequeue the first data element from M2
      
      c.clock.step(1)
      c.io.out.valid.expect(true.B)
      c.io.out.bits.expect(2.U)

    }

  }
}
