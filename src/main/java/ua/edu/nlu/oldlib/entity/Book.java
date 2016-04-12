package ua.edu.nlu.oldlib.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pc9 on 21.03.16.
 */
@Entity
@Table(name = "books2")
public class Book implements Serializable {
    public Book() {
    }

    private Integer bookId;
    private String  eName;
    private String  eYear;
    private String  author;
    private Integer pageCount;
    private Integer corStateId;
    private Integer prewievIndex;
    private String indexBBK;
    private String keyWords;
    private String partName;

    private Set<JoinUserBook> joinUserBooks = new HashSet<JoinUserBook>();


    @Id
    @Column(name = "book_id")
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Column(name = "ename")
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Column(name = "eyear")
    public String geteYear() {
        return eYear;
    }

    public void seteYear(String eYear) {
        this.eYear = eYear;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "page_count")
    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Column(name = "cor_state_id")
    public Integer getCorStateId() {
        return corStateId;
    }

    public void setCorStateId(Integer corStateId) {
        this.corStateId = corStateId;
    }

    @Column(name = "prew_index")
    public Integer getPrewievIndex() {
        return prewievIndex;
    }

    public void setPrewievIndex(Integer prewievIndex) {
        this.prewievIndex = prewievIndex;
    }

    @Column(name = "index_bbk")
    public String getIndexBBK() {
        return indexBBK;
    }

    public void setIndexBBK(String indexBBK) {
        this.indexBBK = indexBBK;
    }
    @Column(name = "key_words")
    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
    @Column(name = "part_name")
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }




    @OneToMany(fetch = FetchType.EAGER,mappedBy = "book",cascade = CascadeType.REMOVE)
    public Set<JoinUserBook> getJoinUserBooks() {
        return joinUserBooks;
    }

    public void setJoinUserBooks(Set<JoinUserBook> joinUserBooks) {
        this.joinUserBooks = joinUserBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", eName='" + eName + '\'' +
                ", eYear='" + eYear + '\'' +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount +
                ", corStateId=" + corStateId +
                ", prewievIndex=" + prewievIndex +
                ", indexBBK='" + indexBBK + '\'' +
                ", keyWords='" + keyWords + '\'' +
                ", partName='" + partName + '\'' +

                '}';
    }
}
