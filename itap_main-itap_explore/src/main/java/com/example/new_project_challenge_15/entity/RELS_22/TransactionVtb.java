package com.example.new_project_challenge_15.entity.RELS_22;
import com.example.new_project_challenge_15.entity.Company;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Node
public class TransactionVtb {
    @Id
    @GeneratedValue
    public Long id;
    @Property("Банк плательщика")
    public String bankPlatelshika;
    @Property("Банк получателя")
    public String bankPoluchatelya;
    @Property("Валюта операции")
    public String valutaOperaciy;
    @Property("Вид операции (КД)")
    public String vidyOperaciy;
    @Property("Дата и время операции")
    public String dataOperaciy;
    @Property("ИИН/БИН плательщика")
    public String iinBinPlatelshika;
    @Property("ИИН/БИН получателя")
    public String iinBinPoluchatelya;
    @Property("Код назначение платежа (КНП)")
    public String codeNaznachenyia;
    @Property("Назначение платежа")
    public String naznachenyePlatezha;
    @Property("Наименование СДП (при наличии)")
    public String naymenovanyeSDP;
    @Property("Наименование/ФИО плательщика")
    public String naymenovanyeFIOplatelshika;
    @Property("Наименование/ФИО получателя")
    public String naymenovanyeFIOpolucahtelya;
    @Property("Номер счета плательщика")
    public String nomerscetaplatelshika;
    @Property("Номер счета получателя")
    public String nomerscetapoluchatelya;
    @Property("Резиденство плательщика")
    public String rezidenstvoplatelshika;
    @Property("Резиденство получателя")
    public String rezidenstvopolucahtelya;
    @Property("Сумма (вал.)")
    public String summavValute;
    @Property("Сумма (тенге)")
    public String summaVTenge;

    @TargetNode
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankPlatelshika() {
        return bankPlatelshika;
    }

    public void setBankPlatelshika(String bankPlatelshika) {
        this.bankPlatelshika = bankPlatelshika;
    }

    public String getBankPoluchatelya() {
        return bankPoluchatelya;
    }

    public void setBankPoluchatelya(String bankPoluchatelya) {
        this.bankPoluchatelya = bankPoluchatelya;
    }

    public String getValutaOperaciy() {
        return valutaOperaciy;
    }

    public void setValutaOperaciy(String valutaOperaciy) {
        this.valutaOperaciy = valutaOperaciy;
    }

    public String getVidyOperaciy() {
        return vidyOperaciy;
    }

    public void setVidyOperaciy(String vidyOperaciy) {
        this.vidyOperaciy = vidyOperaciy;
    }

    public String getDataOperaciy() {
        return dataOperaciy;
    }

    public void setDataOperaciy(String dataOperaciy) {
        this.dataOperaciy = dataOperaciy;
    }

    public String getIinBinPlatelshika() {
        return iinBinPlatelshika;
    }

    public void setIinBinPlatelshika(String iinBinPlatelshika) {
        this.iinBinPlatelshika = iinBinPlatelshika;
    }

    public String getIinBinPoluchatelya() {
        return iinBinPoluchatelya;
    }

    public void setIinBinPoluchatelya(String iinBinPoluchatelya) {
        this.iinBinPoluchatelya = iinBinPoluchatelya;
    }

    public String getCodeNaznachenyia() {
        return codeNaznachenyia;
    }

    public void setCodeNaznachenyia(String codeNaznachenyia) {
        this.codeNaznachenyia = codeNaznachenyia;
    }

    public String getNaznachenyePlatezha() {
        return naznachenyePlatezha;
    }

    public void setNaznachenyePlatezha(String naznachenyePlatezha) {
        this.naznachenyePlatezha = naznachenyePlatezha;
    }

    public String getNaymenovanyeSDP() {
        return naymenovanyeSDP;
    }

    public void setNaymenovanyeSDP(String naymenovanyeSDP) {
        this.naymenovanyeSDP = naymenovanyeSDP;
    }

    public String getNaymenovanyeFIOplatelshika() {
        return naymenovanyeFIOplatelshika;
    }

    public void setNaymenovanyeFIOplatelshika(String naymenovanyeFIOplatelshika) {
        this.naymenovanyeFIOplatelshika = naymenovanyeFIOplatelshika;
    }

    public String getNaymenovanyeFIOpolucahtelya() {
        return naymenovanyeFIOpolucahtelya;
    }

    public void setNaymenovanyeFIOpolucahtelya(String naymenovanyeFIOpolucahtelya) {
        this.naymenovanyeFIOpolucahtelya = naymenovanyeFIOpolucahtelya;
    }

    public String getNomerscetaplatelshika() {
        return nomerscetaplatelshika;
    }

    public void setNomerscetaplatelshika(String nomerscetaplatelshika) {
        this.nomerscetaplatelshika = nomerscetaplatelshika;
    }

    public String getNomerscetapoluchatelya() {
        return nomerscetapoluchatelya;
    }

    public void setNomerscetapoluchatelya(String nomerscetapoluchatelya) {
        this.nomerscetapoluchatelya = nomerscetapoluchatelya;
    }

    public String getRezidenstvoplatelshika() {
        return rezidenstvoplatelshika;
    }

    public void setRezidenstvoplatelshika(String rezidenstvoplatelshika) {
        this.rezidenstvoplatelshika = rezidenstvoplatelshika;
    }

    public String getRezidenstvopolucahtelya() {
        return rezidenstvopolucahtelya;
    }

    public void setRezidenstvopolucahtelya(String rezidenstvopolucahtelya) {
        this.rezidenstvopolucahtelya = rezidenstvopolucahtelya;
    }

    public String getSummavValute() {
        return summavValute;
    }

    public void setSummavValute(String summavValute) {
        this.summavValute = summavValute;
    }

    public String getSummaVTenge() {
        return summaVTenge;
    }

    public void setSummaVTenge(String summaVTenge) {
        this.summaVTenge = summaVTenge;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
