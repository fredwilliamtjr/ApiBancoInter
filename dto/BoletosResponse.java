
package br.com.fwtj.smartnfe.util.inter.dto;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class BoletosResponse {

    private Integer totalPages;
    private Integer totalElements;
    private Integer numberOfElements;
    private Boolean last;
    private Boolean first;
    private Integer size;
    private Summary summary;
    private List<BoletosResponseContent> content = new ArrayList<BoletosResponseContent>();

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<BoletosResponseContent> getContent() {
        return content;
    }

    public void setContent(List<BoletosResponseContent> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("totalPages", totalPages).append("totalElements", totalElements).append("numberOfElements", numberOfElements).append("last", last).append("first", first).append("size", size).append("summary", summary).append("content", content).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(summary).append(numberOfElements).append(last).append(size).append(totalPages).append(first).append(content).append(totalElements).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoletosResponse) == false) {
            return false;
        }
        BoletosResponse rhs = ((BoletosResponse) other);
        return new EqualsBuilder().append(summary, rhs.summary).append(numberOfElements, rhs.numberOfElements).append(last, rhs.last).append(size, rhs.size).append(totalPages, rhs.totalPages).append(first, rhs.first).append(content, rhs.content).append(totalElements, rhs.totalElements).isEquals();
    }

}
