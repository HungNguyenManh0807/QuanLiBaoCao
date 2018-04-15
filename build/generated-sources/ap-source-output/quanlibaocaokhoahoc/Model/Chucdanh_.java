package quanlibaocaokhoahoc.Model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import quanlibaocaokhoahoc.Model.Nhakhoahoc;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-14T12:04:20")
@StaticMetamodel(Chucdanh.class)
public class Chucdanh_ { 

    public static volatile SingularAttribute<Chucdanh, Integer> id;
    public static volatile SingularAttribute<Chucdanh, String> ten;
    public static volatile SingularAttribute<Chucdanh, Nhakhoahoc> nhakhoahoc;
    public static volatile SingularAttribute<Chucdanh, Date> ngayCap;

}