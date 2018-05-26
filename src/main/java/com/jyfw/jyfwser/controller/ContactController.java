package com.jyfw.jyfwser.controller;

import com.jyfw.jyfwser.pojo.em.ContactTypeEnum;
import com.jyfw.jyfwser.pojo.entity.ContactEntity;
import com.jyfw.jyfwser.pojo.entity.UserEntity;
import com.jyfw.jyfwser.service.ContactService;
import com.jyfw.jyfwser.service.DemandService;
import com.jyfw.jyfwser.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author: chunxiao
 * @description:合约控制器
 * @date: created in 19:18 2018/5/26
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private DemandService demandService;

    @PostMapping(value = "/insertContact")
    @ResponseBody
    public JsonResult insertContact(String category, String existsname, Integer existsUid, Integer myuid,
                                    String dealobject, Integer dealnum, Integer dealprice, String dealtime, String desc,
                                    Integer demandId, HttpSession session) {
        UserEntity user = (UserEntity) session.getAttribute("user");
        ContactEntity contact = new ContactEntity();
        //根据双方角色调整信息
        if(category == "卖方") {
            contact.setSellername(existsname);
            contact.setSellerUid(existsUid);
            contact.setBuyername(user.getName());
            contact.setBuyerUid(myuid);
        }else {
            contact.setBuyerUid(existsUid);
            contact.setBuyername(existsname);
            contact.setSellerUid(existsUid);
            contact.setSellername(existsname);
        }
        contact.setDealObject(dealobject);
        contact.setDealNum(dealnum);
        contact.setDealprice(dealprice);
        contact.setDealTime(dealtime);
        contact.setDesc(desc);
        contact.setStatus(ContactTypeEnum.NEWS.getCode());

        contactService.insertContact(contact);
        //修改需求状态
        demandService.updateDemandDoneByDemandId(demandId);

        return JsonResult.createBySuccess();
    }

}
