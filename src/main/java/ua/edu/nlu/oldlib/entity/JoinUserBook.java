package ua.edu.nlu.oldlib.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by pc9 on 23.03.16.
 */
@Entity
@Table(name = "tmp_simple")
public class JoinUserBook  implements Serializable{
    public JoinUserBook() {
    }

    public JoinUserBook(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public JoinUserBook(User user, Book book, Integer bookmark) {
        this.user = user;
        this.book = book;
        this.bookmark = bookmark;
    }

    public JoinUserBook(User user, Book book, Integer bookmark, Range range) {
        this.user = user;
        this.book = book;
        this.bookmark = bookmark;
        this.ranges.add(range);
    }

    public JoinUserBook(User user, Book book, Integer bookmark, Set<Range> ranges) {
        this.user = user;
        this.book = book;
        this.bookmark = bookmark;
        this.ranges = ranges;
    }

    private Integer tmpId;
    private User user;
    private Book book;
    private Integer bookmark;
    private Set<Range> ranges = new HashSet<Range>();
    private Set<Integer> pageSet = new HashSet<Integer>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "join_id")
    public Integer getTmpId() {
        return tmpId;
    }

    public void setTmpId(Integer tmpId) {
        this.tmpId = tmpId;
    }
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Column(name = "bookmark")
    public Integer getBookmark() {
        return bookmark;
    }

    public void setBookmark(Integer bookmark) {
        this.bookmark = bookmark;
    }

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "joinUserBook")
    public Set<Range> getRanges() {
        return ranges;
    }

    public void setRanges(Set<Range> ranges) {
        this.ranges = ranges;
    }

    public Set<Integer> getPageSet(int s){
        Set<Range> rangeSet = this.getRanges();
        Iterator iterator = rangeSet.iterator();
        while (iterator.hasNext()){
            this.pageSet.addAll(getPages((Range) iterator.next()));
        }

        return this.pageSet;
    }

    private Set<Integer> getPages(Range range){
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int i = range.getStart(); i <= range.getFinish(); i ++){
            resultSet.add(i);
        }
        return resultSet;
    }

    @Override
    public String toString() {
        return "JoinUserBook{" +
                "tmpId=" + tmpId +
                ", user=" + user +
                ", book=" + book +
                ", bookmark=" + bookmark +
                ", ranges=" + ranges +
                '}';
    }
}
