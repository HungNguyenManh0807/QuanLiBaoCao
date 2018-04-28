package quanlibaocaokhoahoc.Model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import quanlibaocaokhoahoc.Model.Linhvuc;
import quanlibaocaokhoahoc.Model.Loaibaocao;
import quanlibaocaokhoahoc.Model.NhanghiencuuBaocao;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-28T17:03:18")
@StaticMetamodel(Baocao.class)
public class Baocao_ { 

    public static volatile ListAttribute<Baocao, NhanghiencuuBaocao> nhanghiencuuBaocaoList;
    public static volatile SingularAttribute<Baocao, String> tomTat;
    public static volatile SingularAttribute<Baocao, Linhvuc> iDLinhVuc;
    public static volatile SingularAttribute<Baocao, Loaibaocao> iDLoai;
    public static volatile SingularAttribute<Baocao, String> urlData;
    public static volatile SingularAttribute<Baocao, Integer> id;
    public static volatile SingularAttribute<Baocao, String> ten;
    public static volatile SingularAttribute<Baocao, Date> thoiGian;
    public static volatile SingularAttribute<Baocao, String> url;

}