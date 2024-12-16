package gestiondette.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50, unique = true)
    private String libelle;

    private int qte_stock;
    @Column(columnDefinition = "boolean default false")
    private boolean is_archived;
    private int prix;

    @OneToMany(mappedBy = "article")
    private List<DetailDebtRequest> detailDebts;

    @Override
    public String toString() {
        return "Article [id=" + id + ", libelle=" + libelle + ", qteStock=" + qte_stock + ", prix=" + prix + "]";
    }
}