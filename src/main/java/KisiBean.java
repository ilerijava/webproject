import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.tutev.personelozluk.entity.Kisi;
import com.tutev.personelozluk.service.KisiServis;

@ManagedBean(name = "kisiView")
@ViewScoped
public class KisiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Kisi> kisiList;

	private KisiServis kisiServis = new KisiServis();

	@PostConstruct
	public void initialize() {
		kisiList = (kisiServis.getAll());
	}

	public List<Kisi> getKisiList() {
		return kisiList;
	}

	public void setKisiList(List<Kisi> kisiList) {
		this.kisiList = kisiList;
	}

}
