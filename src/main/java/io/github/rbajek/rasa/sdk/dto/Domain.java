package io.github.rbajek.rasa.sdk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter @Setter @ToString
public class Domain {

    private Config config;
    private List<Map<String, Intent>> intents;
    private List<String> entities;
    private Map<String, Slot> slots;
    private Map<String, List<Response>> responses;
    private List<String> actions;
    
    private SessionConfig sessionConfig;
    private Map<String, Form> forms;

    @Getter @Setter @ToString
    public static class SessionConfig {
        @JsonProperty("session_expiration_time")
    	private int sessionExpirationTime;
        
        @JsonProperty("carry_over_slots_to_new_session")
    	private Boolean carryOverSlotsToNewNession;
    	
    }

    @Getter @Setter @ToString
    public static class Intent {
        @JsonProperty("use_entities")
        private Boolean use_entities;
    }

    @Getter @Setter @ToString
    public static class Slot {
        @JsonProperty("auto_fill")
        private Boolean autoFill;

        @JsonProperty("initial_value")
        private String initialValue;

        private String type;

        private List<String> values;
        
        @JsonProperty("influence_conversation")
        private Boolean influenceConversation;
    }

    @Getter @Setter @ToString
    public static class Response {
        private String image;
        private String text;
        private String language;
        private String metadata;
        private List<Button> quickReplies;
        private List<Element> elements;

    }

    @Getter @Setter @ToString
    public static class Element {
        private List<Button> buttons;
        private String imageUrl;
        private String subtitle;
        private String title;
    }

    @Getter @Setter @ToString
    public static class Button {
        private String payload;
        private String title;
        private String type;
    }

    @Getter @Setter @ToString
    public static class Config {
        @JsonProperty("store_entities_as_slots")
        private Boolean storeEntitiesAsSlots;
    }
    
    @Getter @Setter @ToString
    public static class Form {
    	private Boolean collectInBotfront;
    	private String description;
        private GraphElements graphElements;
        private String groupName;
        private String name;
        
        @JsonProperty("slots")
        private List<UsedSlot> usedSlots;
        private Long updatedAt;
    }

    @Getter @Setter @ToString
    public static class GraphElements {
    	private Boolean collectInBotfront;
    	private String description;
        private List<UsedSlot> slots;
        private Long updatedAt;
    }
    @Getter @Setter @ToString
    public static class UsedSlot {
    	private Boolean collectInBotfront;
    	private String description;
        private String groupName;
        private String name;
        private Long updatedAt;
    }
}
