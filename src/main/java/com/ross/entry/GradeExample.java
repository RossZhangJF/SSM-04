package com.ross.entry;

import java.util.ArrayList;
import java.util.List;

public class GradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGrIdIsNull() {
            addCriterion("gr_id is null");
            return (Criteria) this;
        }

        public Criteria andGrIdIsNotNull() {
            addCriterion("gr_id is not null");
            return (Criteria) this;
        }

        public Criteria andGrIdEqualTo(Integer value) {
            addCriterion("gr_id =", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotEqualTo(Integer value) {
            addCriterion("gr_id <>", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdGreaterThan(Integer value) {
            addCriterion("gr_id >", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gr_id >=", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdLessThan(Integer value) {
            addCriterion("gr_id <", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdLessThanOrEqualTo(Integer value) {
            addCriterion("gr_id <=", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdIn(List<Integer> values) {
            addCriterion("gr_id in", values, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotIn(List<Integer> values) {
            addCriterion("gr_id not in", values, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdBetween(Integer value1, Integer value2) {
            addCriterion("gr_id between", value1, value2, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gr_id not between", value1, value2, "grId");
            return (Criteria) this;
        }

        public Criteria andGrNameIsNull() {
            addCriterion("gr_name is null");
            return (Criteria) this;
        }

        public Criteria andGrNameIsNotNull() {
            addCriterion("gr_name is not null");
            return (Criteria) this;
        }

        public Criteria andGrNameEqualTo(String value) {
            addCriterion("gr_name =", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameNotEqualTo(String value) {
            addCriterion("gr_name <>", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameGreaterThan(String value) {
            addCriterion("gr_name >", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameGreaterThanOrEqualTo(String value) {
            addCriterion("gr_name >=", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameLessThan(String value) {
            addCriterion("gr_name <", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameLessThanOrEqualTo(String value) {
            addCriterion("gr_name <=", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameLike(String value) {
            addCriterion("gr_name like", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameNotLike(String value) {
            addCriterion("gr_name not like", value, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameIn(List<String> values) {
            addCriterion("gr_name in", values, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameNotIn(List<String> values) {
            addCriterion("gr_name not in", values, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameBetween(String value1, String value2) {
            addCriterion("gr_name between", value1, value2, "grName");
            return (Criteria) this;
        }

        public Criteria andGrNameNotBetween(String value1, String value2) {
            addCriterion("gr_name not between", value1, value2, "grName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}