package quanlibaocaokhoahoc.Model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import quanlibaocaokhoahoc.Model.Chucdanh;
import quanlibaocaokhoahoc.Model.Coquan;
import quanlibaocaokhoahoc.Model.NhanghiencuuBaocao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-02T23:37:36")
@StaticMetamodel(Nhanghiencuu.class)
public class Nhanghiencuu_ { 

    public static volatile ListAttribute<Nhanghiencuu, NhanghiencuuBaocao> nhanghiencuuBaocaoList;
    public static volatile SingularAttribute<Nhanghiencuu, Coquan> iDCoQuan;
    public static volatile SingularAttribute<Nhanghiencuu, Date> ngaySinh;
    public static volatile SingularAttribute<Nhanghiencuu, Integer> id;
    public static volatile SingularAttribute<Nhanghiencuu, Chucdanh> iDChucDanh;
    public static volatile SingularAttribute<Nhanghiencuu, String> ten;

}