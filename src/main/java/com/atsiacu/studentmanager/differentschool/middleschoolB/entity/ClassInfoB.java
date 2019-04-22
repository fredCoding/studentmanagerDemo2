package com.atsiacu.studentmanager.differentschool.middleschoolB.entity;

import com.atsiacu.studentmanager.differentschool.commonbasicentity.ClassInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString(callSuper = true)
@Setter
@Getter
@Document("ClassInfo")
public class ClassInfoB extends ClassInfo {
    //有定制化属性添加即可

}
