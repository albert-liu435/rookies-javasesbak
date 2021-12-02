package com.rookie.bigdata.util.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname ListStream
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/30 11:38
 * @Version 1.0
 */
public class ListStream {

//    public static void main(String[] args) {
//        List<String> ispCodeList = new ArrayList<>();
//        ispCodeList.add("CAA");
//        ispCodeList.add("SAA");
//        ispCodeList.add("CAA");
//        ispCodeList.add("SAA");
//        ispCodeList.add("CAA");
//        System.out.println(ispCodeList.toString());
//        // distinct()只能对于简单的如List<String>，List<int>等起作用，而对于List<T>不起作用
//        ispCodeList = ispCodeList.stream().distinct().collect(Collectors.toList());
//        System.out.println(ispCodeList.toString());
//    }


//    public static void main(String[] args) {
//        // 根据key为Id去重
//        Map<String, BlockDefDto> blockDefDtoMap = new HashMap<>(16);
//        BlockDefDto blockDefDto = new BlockDefDto();
//        blockDefDto.setBlockId(2);
//        blockDefDto.setBlockName("Name11");
//        blockDefDtoMap.put(blockDefDto.getBlockId().toString(), blockDefDto);
//        blockDefDto = new BlockDefDto();
//        blockDefDto.setBlockId(2);
//        blockDefDto.setBlockName("Name22");
//        blockDefDtoMap.put(blockDefDto.getBlockId().toString(), blockDefDto);
//        blockDefDto = new BlockDefDto();
//        blockDefDto.setBlockId(3);
//        blockDefDto.setBlockName("Name33");
//        blockDefDtoMap.put(blockDefDto.getBlockId().toString(), blockDefDto);
//        // 1-简单转换
//        List<BlockDefDto> blockDefDtoList1 = new ArrayList<>();
//        blockDefDtoMap.forEach((blockId, blockDefDtoTemp) -> {
//            blockDefDtoList1.add(blockDefDtoTemp);
//        });
//        // 2-快速转换
//        List<BlockDefDto> blockDefDtoList2 = blockDefDtoMap.values().stream().collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(blockDefDtoList1));
//        System.out.println(JSON.toJSONString(blockDefDtoList2));
//    }


}
