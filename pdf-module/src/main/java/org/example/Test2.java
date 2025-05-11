package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    static Set<String> fixedSet = Set.of("gjs-wrapper","gjs-m360-content","gjs-content","gjs-m360-text");
    static Map<String,String> fixedMap = Map.of("gjs-wrapper","mtz-builder-only-wrapper",
            "gjs-m360-content", "mtz-builder-only-m360-content",
            "gjs-content" , "mtz-builder-only-content",
            "gjs-m360-text" , "mtz-builder-only-m360-text");

    static String json = """
            {
                "pages": [
                    {
                        "id": "PSJejBrgIUmzpE6C",
                        "type": "main",
                        "frames": [
                            {
                                "id": "QcY6wPDlol8EgIMU",
                                "component": {
                                    "head": {
                                        "type": "head"
                                    },
                                    "type": "wrapper",
                                    "docEl": {
                                        "tagName": "html"
                                    },
                                    "classes": [
                                        "gjs-wrapper"
                                    ],
                                    "stylable": [
                                        "background",
                                        "background-color",
                                        "background-image",
                                        "background-repeat",
                                        "background-attachment",
                                        "background-position",
                                        "background-size"
                                    ],
                                    "components": [
                                        {
                                            "type": "m360-content",
                                            "classes": [
                                                "gjs-m360-content"
                                            ],
                                            "components": [
                                                {
                                                    "type": "component-header",
                                                    "attributes": {
                                                        "class": "gjs-component-header",
                                                        "parentType": "m360-content",
                                                        "isComponentHeader": true
                                                    },
                                                    "components": []
                                                },
                                                {
                                                    "type": "content",
                                                    "classes": [
                                                        "gjs-content"
                                                    ],
                                                    "attributes": {
                                                        "contenteditable": false
                                                    },
                                                    "components": [
                                                        {
                                                            "type": "m360-text",
                                                            "classes": [
                                                                "gjs-m360-text"
                                                            ],
                                                            "attributes": {
                                                                "id": "i6n1"
                                                            },
                                                            "components": [
                                                                {
                                                                    "type": "component-header",
                                                                    "attributes": {
                                                                        "class": "gjs-component-header",
                                                                        "parentType": "m360-text",
                                                                        "isComponentHeader": true
                                                                    },
                                                                    "components": []
                                                                },
                                                                {
                                                                    "type": "text",
                                                                    "classes": [
                                                                        "gjs-text"
                                                                    ],
                                                                    "content": "<div class=\\"gjs-wrapper\\"><div class=\\"gjs-content\\" id=\\"icto\\"><div class=\\"gjs-m360-text\\" id=\\"ig5w\\"><div contenteditable id=\\"i1zh\\" class=\\"gjs-text\\"><span contenteditable data-teams=\\"true\\" class=\\"gjs-text\\">Dear {{client_name}},</span><div><span contenteditable draggable=\\"true\\" data-teams=\\"true\\" class=\\"gjs-text\\"><br/></span></div><div><span contenteditable draggable=\\"true\\" data-teams=\\"true\\" class=\\"gjs-text\\">Attached is the invoice for activity during the period {{billing_period}} for the {{bank_name}}. </span></div><div id=\\"i2ak5\\" draggable=\\"true\\"><span contenteditable draggable=\\"true\\" data-teams=\\"true\\" class=\\"gjs-text\\"><br/></span></div><div id=\\"i7zuv\\" draggable=\\"true\\"><span contenteditable draggable=\\"true\\" data-teams=\\"true\\" class=\\"gjs-text\\"><b contenteditable class=\\"gjs-text\\">For any queries regarding the invoice statement, please contact Liink support</b></span></div><div id=\\"iueb2\\" draggable=\\"true\\"><span contenteditable draggable=\\"true\\" data-teams=\\"true\\" class=\\"gjs-text\\"><br/></span></div><div id=\\"i8fka\\" draggable=\\"true\\"><span contenteditable draggable=\\"true\\" data-teams=\\"true\\" class=\\"gjs-text\\">Best Regards,</span></div><div id=\\"idduf\\" draggable=\\"true\\"><span contenteditable draggable=\\"true\\" data-teams=\\"true\\" class=\\"gjs-text\\">Liink by JPM</span></div></div></div></div></div>",
                                                                    "attributes": {
                                                                        "id": "ieutc",
                                                                        "contenteditable": true
                                                                    }
                                                                }
                                                            ]
                                                        }
                                                    ]
                                                }
                                            ]
                                        }
                                    ]
                                }
                            }
                        ]
                    }
                ],
                "assets": [],
                "styles": [
                    {
                        "group": "cmp:wrapper",
                        "style": {
                            "display": "flex",
                            "row-gap": "1rem",
                            "column-gap": "1rem",
                            "padding-top": "1rem",
                            "padding-left": "1rem",
                            "padding-right": "1rem",
                            "flex-direction": "column",
                            "padding-bottom": "1rem"
                        },
                        "selectors": [
                            "gjs-wrapper"
                        ]
                    },
                    {
                        "style": {
                            "--m360-rte-edit-icon": "url('edit-icon.svg')",
                            "--m360-rte-delete-icon": "url('delete-icon.svg')",
                            "--m360-rte-token_border": "1px solid #D9D9D9",
                            "--m360-rte-token_border-radius": "4px",
                            "--m360-rte-token_background-color": "#F5F5F5",
                            "--m360-rte-actions_popover-box-shadow": "0 3px 6px -4px rgba(0, 0, 0, 0.12), 0 6px 16px 0 rgba(0, 0, 0, 0.08), 0 9px 28px 8px rgba(0, 0, 0, 0.05)",
                            "--m360-rte-button_secondary-font-color": "#52C41A",
                            "--m360-rte-token-hover_background-color": "#F5F5F5",
                            "--m360-rte-token-dropdown_background-color": "#FFFFFF"
                        },
                        "selectors": [],
                        "selectorsAdd": ":root"
                    },
                    {
                        "style": {
                            "text-wrap-mode": "wrap",
                            "white-space-collapse": "preserve"
                        },
                        "selectors": [],
                        "selectorsAdd": "[data-gjs-type]"
                    },
                    {
                        "group": "cmp:component-header",
                        "style": {
                            "width": "100%",
                            "display": "inline-flex",
                            "background-clip": "initial",
                            "background-size": "initial",
                            "background-color": "rgb(255, 255, 255)",
                            "background-image": "initial",
                            "background-origin": "initial",
                            "background-repeat": "initial",
                            "background-attachment": "initial",
                            "background-position-x": "initial",
                            "background-position-y": "initial"
                        },
                        "selectors": [
                            "gjs-component-header"
                        ]
                    },
                    {
                        "group": "cmp:content",
                        "style": {
                            "height": "100%",
                            "content": "\\"Drag and drop content elements here\\"",
                            "display": "flex",
                            "opacity": "0.5",
                            "align-items": "center",
                            "justify-content": "center"
                        },
                        "selectors": [],
                        "selectorsAdd": ".gjs-content:empty::after"
                    },
                    {
                        "group": "cmp:content",
                        "style": {
                            "height": "auto",
                            "display": "flex",
                            "row-gap": "1rem",
                            "column-gap": "1rem",
                            "min-height": "50vh",
                            "padding-top": "1rem",
                            "padding-left": "1rem",
                            "padding-right": "1rem",
                            "flex-direction": "column",
                            "padding-bottom": "1rem"
                        },
                        "selectors": [
                            "gjs-content"
                        ]
                    },
                    {
                        "group": "cmp:m360-content",
                        "style": {
                            "width": "100%",
                            "display": "flex",
                            "flex-direction": "column",
                            "background-clip": "initial",
                            "background-size": "initial",
                            "background-color": "rgb(255, 255, 255)",
                            "background-image": "initial",
                            "background-origin": "initial",
                            "background-repeat": "initial",
                            "background-attachment": "initial",
                            "background-position-x": "initial",
                            "background-position-y": "initial"
                        },
                        "selectors": [
                            "gjs-m360-content"
                        ]
                    },
                    {
                        "group": "cmp:text",
                        "style": {
                            "content": "\\"Enter your text\\"",
                            "display": "block",
                            "opacity": "0.3"
                        },
                        "selectors": [],
                        "selectorsAdd": ".gjs-text:empty::after"
                    },
                    {
                        "group": "cmp:text",
                        "style": {
                            "cursor": "text",
                            "outline-color": "initial",
                            "outline-style": "none",
                            "outline-width": "initial",
                            "pointer-events": "auto",
                            "border-top-color": "initial",
                            "border-top-style": "none",
                            "border-top-width": "initial",
                            "border-left-color": "initial",
                            "border-left-style": "none",
                            "border-left-width": "initial",
                            "border-image-slice": "initial",
                            "border-image-width": "initial",
                            "border-right-color": "initial",
                            "border-right-style": "none",
                            "border-right-width": "initial",
                            "border-bottom-color": "initial",
                            "border-bottom-style": "none",
                            "border-bottom-width": "initial",
                            "border-image-outset": "initial",
                            "border-image-repeat": "initial",
                            "border-image-source": "initial"
                        },
                        "selectors": [
                            "gjs-text"
                        ]
                    },
                    {
                        "group": "cmp:m360-text",
                        "style": {
                            "width": "100%",
                            "pointer-events": "auto"
                        },
                        "selectors": [
                            "gjs-m360-text"
                        ]
                    },
                    {
                        "style": {
                            "background": "#FFFFFF"
                        },
                        "selectors": [
                            "#i6n1"
                        ]
                    },
                    {
                        "style": {
                            "width": "100%",
                            "height": "100%",
                            "padding": "25px"
                        },
                        "selectors": [
                            "#ieutc"
                        ]
                    }
                ],
                "symbols": [],
                "dataSources": []
            }
            """;

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = objectMapper.readValue(json, new TypeReference<>() {});
        List<Map<String,Object>> list = (List<Map<String,Object>>)map.get("styles");
        list = list.stream().map(e->{
            if(e.containsKey("selectors")){
                List<String> selectors = (List<String>)e.get("selectors");
                selectors = selectors.stream().filter(s-> !StringUtils.equalsAnyIgnoreCase(s,"gjs-wrapper","gjs-content","#ieutc")).collect(Collectors.toList());
                e.put("selectors",selectors);
            }
            return e;
        }).collect(Collectors.toList());
        map.put("styles",list);

        List<Map<String,Object>> list1 = (List<Map<String,Object>>)map.get("pages");
        list1=list1.stream().map(e1->{
            if(e1.containsKey("frames")){
                List<Map<String,Object>> listE1 = (List<Map<String,Object>>)e1.get("frames");
                listE1 = listE1.stream().map(e2-> {
                    if(e2.containsKey("component")){
                       Map<String, Object> component1 = (Map<String, Object>) e2.get("component");
                       if(component1.containsKey("classes")){
                           List<String> classes = (List<String>)component1.get("classes");
                           for(String item : fixedSet){
                               if(classes.contains(item)){
                                   classes.add(fixedMap.get(item));
                               }
                           }
                           component1.put("classes",classes);
                        }
                        component1 = recurr(component1);
                       e2.put("component",component1);
                    }
                    return e2;
                }).collect(Collectors.toList());
                e1.put("frames",listE1);
            }
            return e1;
        }).collect(Collectors.toList());

        map.put("pages",list1);
        System.out.println(objectMapper.writeValueAsString(map));
    }

    public static Map<String,Object> recurr(Map<String,Object> map){
        if(!map.containsKey("components")){
            return map;
        }else{
            List<Map<String,Object>> list = (List<Map<String,Object>>)map.get("components");
            if(list==null || list.isEmpty()){
                return map;
            }else{
                list=list.stream().map(e->{
                    if(e.containsKey("classes")){
                        List<String> classes = (List<String>)e.get("classes");
                        for(String item : fixedSet){
                            if(classes.contains(item)){
                                classes.add(fixedMap.get(item));
                            }
                        }
                        e.put("classes",classes);
                    }
                    if(e.containsKey("components")){
                        recurr(e);
                    }
                    return e;
                }).collect(Collectors.toList());
                map.put("components",list);
                return map;
            }
        }
    }
}
