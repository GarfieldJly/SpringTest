package com.garfield.wechatorder.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.garfield.wechatorder.bean.IdiomBo;
import com.garfield.wechatorder.bean.XiehouyuBo;
import com.garfield.wechatorder.dal.domain.IdiomDo;
import com.garfield.wechatorder.dal.domain.XiehouyuDo;
import com.garfield.wechatorder.dal.mapper.IdiomDoMapper;
import com.garfield.wechatorder.dal.mapper.XiehouyuDoMapper;
import com.garfield.wechatorder.service.FileService;
import com.garfield.wechatorder.util.FileUtil;
import com.garfield.wechatorder.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Jingly on 2018/8/21.
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private IdiomDoMapper idiomDoMapper;

    @Autowired
    private XiehouyuDoMapper xiehouyuDoMapper;

    @Override
    public String readIdiom(String fileName) {
        String result = fileUtil.readToString(fileName);

        IdiomBo[] idiomBos = JsonUtil.parseToObject(result,IdiomBo[].class);
        List<IdiomBo> idiomBoList = Arrays.asList(idiomBos);
        if(idiomBoList.size() == 0){
            return null;
        }
        System.out.println("idiomBo is:"+idiomBos.length);
        List<IdiomDo> idiomDoList = new ArrayList<>();
        for (IdiomBo idiomBo : idiomBoList) {
            IdiomDo idiomDo = new IdiomDo();
            idiomDo.setAbbreviation(idiomBo.getAbbreviation());
            idiomDo.setDerivation(idiomBo.getDerivation());
            idiomDo.setExample(idiomBo.getExample());
            idiomDo.setExplanation(idiomBo.getExplanation());
            idiomDo.setPinyin(idiomBo.getPinyin());
            idiomDo.setWord(idiomBo.getWord());
            idiomDo.setCreatedAt(System.currentTimeMillis() / 1000);
            idiomDo.setUpdatedAt(System.currentTimeMillis() / 1000);
            idiomDo.setIsDeleted(0);
            idiomDoList.add(idiomDo);
        }
        idiomDoMapper.insertList(idiomDoList);
        return result;
    }

    @Override
    public String readXiehouyu(String fileName) {
        String result = fileUtil.readToString(fileName);

        XiehouyuBo[] xiehouyuBos = JsonUtil.parseToObject(result,XiehouyuBo[].class);
        List<XiehouyuBo> xiehouyuBoList = Arrays.asList(xiehouyuBos);
        System.out.println("xiehouyuBos is:"+xiehouyuBos.length);
        if(xiehouyuBoList.size() == 0){
            return null;
        }
        List<XiehouyuDo> xiehouyuDoList = new ArrayList<>();
        for(XiehouyuBo xiehouyuBo : xiehouyuBoList){
            XiehouyuDo xiehouyuDo = new XiehouyuDo();
            xiehouyuDo.setRiddle(xiehouyuBo.getRiddle());
            xiehouyuDo.setAnswer(xiehouyuBo.getAnswer());
            xiehouyuDoList.add(xiehouyuDo);
        }
        xiehouyuDoMapper.insertList(xiehouyuDoList);
        return result;

    }
}