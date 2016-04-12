package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc9 on 23.03.16.
 */
@Entity
@Table(name = "range")
public class Range implements Serializable {
    private Range() {
    }

    public Range(Integer start, Integer finish) {
        this.start = start;
        this.finish = finish;

    }

    private Integer range_id;
    private Integer start;
    private Integer finish;
    private JoinUserBook joinUserBook;
    private List<Integer> rangeList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "range_id")
    public Integer getRange_id() {
        return range_id;
    }

    public void setRange_id(Integer range_id) {
        this.range_id = range_id;
    }

    @Column(name = "start")
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Column(name = "finish")
    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "join_id")
    public JoinUserBook getJoinUserBook() {
        return joinUserBook;
    }

    public void setJoinUserBook(JoinUserBook joinUserBook) {
        this.joinUserBook = joinUserBook;
    }


    @Override
    public String toString() {
        return "Range{" +
                "range_id=" + range_id +
                ", start=" + start +
                ", finish=" + finish +
                //", joinUserBook=" + joinUserBook +
                '}'+"\n";
    }

    private void setRangeArray(Integer start, Integer finish) {


    }

    public List<Integer> getRangeList(int s){
        this.rangeList = new ArrayList<Integer>(this.finish - this.start);
        for (int i = this.start; i < this.finish; i ++){
            rangeList.add(i);
        }
        return this.rangeList;
    }


}
