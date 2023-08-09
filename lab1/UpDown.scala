package lab1

import chisel3._
import chisel3.util._

class UpDown(n: Int) extends Module {
  val io = IO(new Bundle {
    val data_in = Input(UInt(n.W))
    val reload = Input(Bool())
    val out = Output(Bool())
  })

  val counter = RegInit(0.U(n.W))
  val countingUp = RegInit(true.B)

  when(io.reload) {
    counter := 0.U
    countingUp := true.B
  } .otherwise {
    when(countingUp) {
      when(counter === (io.data_in - 1.U)) {
        countingUp := false.B
      } .otherwise {
        counter := counter + 1.U
      }
    } .otherwise {
      when(counter === 0.U) {
        countingUp := true.B
      } .otherwise {
        counter := counter - 1.U
      }
    }
  }

  io.out := counter > 0.U
}
