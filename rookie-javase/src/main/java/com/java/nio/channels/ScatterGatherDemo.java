package com.java.nio.channels;

/**
 * @Classname ScatterGatherDemo
 * @Description 。对于一个write操作而言，数据是从几个缓冲区按顺序抽取（称为gather）并沿着通道发送的。缓冲区本身并不需要具备这种gather的能力（通常它们也没有此能力）。
 * 该gather过程的效果就好比全部缓冲区的内容被连结起来，并在发送数据前存放到一个大的缓冲区中。对于read操作而言，从通道读取的数据会按顺序被散布（称为scatter）到多个缓冲
 * 区，将每个缓冲区填满直至通道中的数据或者缓冲区的最大空间被消耗完。
 * @Author rookie
 * @Date 2022/2/22 10:30
 * @Version 1.0
 */
public class ScatterGatherDemo {


}
