import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

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

	public void satirDuzenle(RowEditEvent event) {
		Kisi kisi = (Kisi) event.getObject();
		kisiServis.update(kisi);
		FacesMessage msg = new FacesMessage("Düzenleme Yapýldý",
				kisi.getAd() + " " + kisi.getSoyad());
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void satirSil(Kisi kisi) {
		kisiServis.delete(kisi);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kiþi Silindi", kisi.getAd() + " " + kisi.getSoyad());
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void satirIptal(RowEditEvent event) {
		Kisi kisi = kisiServis.get((Kisi) event.getObject());
		FacesMessage msg = new FacesMessage("Düzenleme Ýptal Edildi",
				kisi.getAd() + " " + kisi.getSoyad());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


}
