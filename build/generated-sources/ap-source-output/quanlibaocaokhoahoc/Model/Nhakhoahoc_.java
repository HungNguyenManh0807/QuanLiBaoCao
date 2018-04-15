package quanlibaocaokhoahoc.Model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import quanlibaocaokhoahoc.Model.Chucdanh;
import quanlibaocaokhoahoc.Model.Coquan;
import quanlibaocaokhoahoc.Model.NhakhoahocBaocao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-14T12:04:20")
@StaticMetamodel(Nhakhoahoc.class)
public class Nhakhoahoc_ { 

    public static volatile SingularAttribute<Nhakhoahoc, Coquan> iDCoQuan;
    public static volatile SingularAttribute<Nhakhoahoc, Date> ngaySinh;
    public static volatile SingularAttribute<Nhakhoahoc, Integer> id;
    public static volatile SingularAttribute<Nhakhoahoc, Chucdanh> iDChucDanh;
    public static volatile SingularAttribute<Nhakhoahoc, String> ten;
    public static volatile SingularAttribute<Nhakhoahoc, NhakhoahocBaocao> nhakhoahocBaocao;

}